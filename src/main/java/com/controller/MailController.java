package com.controller;

import com.bean.Mail;
import com.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ${邹} on 2019/1/24.
 * 描述：
 */
@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService mailService;

    @RequestMapping(value = "register")
    @ResponseBody
//    @RequestMapping(value = "register",produces = "text/plain;charset=utf-8")
    public String reg(Mail mail) throws Exception {
        mailService.save( mail );
        return "注册成功，去邮箱激活吧";
    }
    @RequestMapping("/activate")
    public String activate(Mail mail){
        mailService.update( mail );
        return "../../index";
    }

    @RequestMapping("/findUsername")
    @ResponseBody
    public List<Mail> findUsername(String username){
        List<Mail> mail = (List<Mail>) mailService.findUsername( username );
        return mail;
    }
}
