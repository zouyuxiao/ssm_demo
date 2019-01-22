package com.controller;

import com.bean.UpFile;
import com.service.UpFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ${邹} on 2019/1/20.
 * 描述：
 */
@RequestMapping("/file")
@Controller
public class UpFileController {
    @Autowired
    UpFileService fileService;

    @RequestMapping("/fileup")
    //参数中的files要和页面中input输入框的name值相同
    public String fileup(MultipartFile[] files, HttpServletRequest request) throws IllegalStateException, IOException {
        //获取文件上传路径
        String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println(path);
        StringBuffer stringBuffer=new StringBuffer();
        for (MultipartFile multipartFile : files) {
            if(!multipartFile.isEmpty()) {
                //将多个文件名拼接在一个字符串中，用;分隔
                stringBuffer.append(multipartFile.getOriginalFilename());
                stringBuffer.append(";");
                File dir=new File(path, multipartFile.getOriginalFilename());
                if(!dir.exists()) {
                    dir.mkdirs();
                }
                multipartFile.transferTo(dir);
            }

        }
        //去除最后一个;号
        String s=stringBuffer.substring(0, stringBuffer.length()-1);
        //存入数据库
        fileService.InsertUpFile(new UpFile( (long) 0, s, path));
        System.out.println(s);
        //重定向至显示页面
        return "redirect:/file/showallfiles";
    }
    @RequestMapping("/showallfiles")
    public String showAllFile(Model model) {
        //获取所有文件
        List<UpFile> allfiles=fileService.selectAllFile();
        //新建map存储文件id和name,其中id作为键
        HashMap<String, Object> map=new HashMap<>();
        for (UpFile upFile : allfiles) {
            //分割文件名字符串，将每个文件名添加到list中，
            List<String> filenamelist=new ArrayList<>();
            String[] filenamearr=upFile.getFilename().split(";");
            for (String string : filenamearr) {
                filenamelist.add(string);
            }
            //list作为map的值
            map.put(upFile.getId()+"", filenamelist);
        }
        model.addAttribute("files", map);
        return "/showfile";
    }
    @ResponseBody
    @RequestMapping("/downfile")
    public String downfile(String filename, String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(filename+id);
        //根据id获取文件上传路径
        UpFile upFile=fileService.selectFileById(Integer.parseInt(id));
        String fileName = upFile.getFilepath()+"/"+filename;
        //防止中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        System.out.println(filename);
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;fileName=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
        return "OK";
    }
}
