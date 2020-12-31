package com.abraham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author long
 * @date 2020/11/10
 */
@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/about-me")
    public String about(){
        return "front-desk/about-me";
    }

    @RequestMapping("/blog-type")
    public String type(){
        return "front-desk/blog-type";
    }

    @RequestMapping("/message")
    public String message(){
        return "front-desk/message-board";
    }

    @RequestMapping("/friend-link")
    public String friendLink(){
        return "front-desk/friend-link";
    }

}
