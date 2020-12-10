package com.abraham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author long
 * @date 2020/11/11
 */
@Controller
@RequestMapping("/admin/todo")
public class TodoListController {

    @RequestMapping("")
    public String todoList(){
        return "admin/abraham/todo-list";
    }
}
