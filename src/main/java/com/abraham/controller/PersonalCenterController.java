package com.abraham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author long
 * @date 2020/11/11
 */
@Controller
@RequestMapping("/personal")
public class PersonalCenterController {

    @RequestMapping("/profile")
    public String profile(){
        return "admin/personal/profile";
    }

    @RequestMapping("/wallet")
    public String wallet(){
        return "admin/coming-soon";
    }

    @RequestMapping("/register")
    public String register(){
        return "admin/personal/register";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "admin/index";
    }
}
