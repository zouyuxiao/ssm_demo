package com.controller;

import com.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.service.UserService;

/**
 * Created by ${邹} on 2019/1/11.
 * 描述：
 */
@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public String register(User user, @RequestParam String username,
                           @RequestParam String password){
        user.setUsername( username );
        user.setPassword( password );
        userService.register( user );
        return "success";
    }
    @RequestMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model){
        User name = userService.login( username );
        if (name == null){
            model.addAttribute( "msg","用户不存在" );
            return "../../index";
        }
        if (username == null || password == null){
           model.addAttribute( "msg" ,"用户名或密码不能为空");
           return "../../index";
        }
        return "success";
    }
}
