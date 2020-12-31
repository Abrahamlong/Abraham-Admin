package com.abraham.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author long
 * @date 2020/11/11
 */
@Controller
@RequestMapping("/user")
public class UserCenterController {

    @RequestMapping("/permission-types")
    public String permissionTypes(){
        return "admin/users/permission-types";
    }

    @RequestMapping("/user-management")
    public String userManagement(){
        return "admin/users/user-management";
    }

    @RequestMapping("/user-permission")
    public String userPermission(){
        return "admin/users/user-permission";
    }
}
