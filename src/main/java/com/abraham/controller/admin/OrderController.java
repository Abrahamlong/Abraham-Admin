package com.abraham.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author long
 * @date 2020/11/11
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/achievement")
    public String achievement(){
        return "admin/order/achievement";
    }

    @RequestMapping("/achievement-details")
    public String achievementDetails(){
        return "admin/order/achievement-details";
    }

    @RequestMapping("/my-order")
    public String myOrder(){
        return "admin/order/my-order";
    }
}
