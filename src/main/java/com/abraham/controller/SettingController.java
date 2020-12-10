package com.abraham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author long
 * @date 2020/11/11
 */
@Controller
@RequestMapping("/setting")
public class SettingController {

    @RequestMapping("/music")
    public String music(){
        return "admin/coming-soon";
    }

    @RequestMapping("/background")
    public String background(){
        return "admin/coming-soon";
    }

    @RequestMapping("/blog-style")
    public String blogStyle(){
        return "admin/coming-soon";
    }
}
