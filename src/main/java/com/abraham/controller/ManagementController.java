package com.abraham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author long
 * @date 2020/11/11
 */
@Controller
@RequestMapping("/management")
public class ManagementController {

    @RequestMapping("/gallery-management")
    public String galleryManagement(){
        return "admin/management/gallery-management";
    }

    @RequestMapping("/comment-management")
    public String commentManagement(){
        return "admin/management/comment-management";
    }

    @RequestMapping("/file-management")
    public String fileManagement(){
        return "admin/management/file-management";
    }

    @RequestMapping("/note-management")
    public String noteManagement(){
        return "admin/coming-soon";
    }

}
