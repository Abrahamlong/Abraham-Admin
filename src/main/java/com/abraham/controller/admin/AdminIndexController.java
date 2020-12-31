package com.abraham.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author long
 * @date 2020/11/10
 */
@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    @RequestMapping("/index")
    public String index(){
        return "admin/index";
    }

}
