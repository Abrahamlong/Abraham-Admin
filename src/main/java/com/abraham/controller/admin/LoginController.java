package com.abraham.controller.admin;

import com.abraham.service.UserService;
import com.abraham.vo.LoginUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @author: Long
 * @date Create in 14:51 2020/12/1
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping({"","/login"})
    public String admin(){
        return "admin/personal/login";
    }

    @RequestMapping(value = "/toLogin", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session){
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            session.setAttribute("username", username);
            return "admin/index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误!!");
            return "redirect:/admin";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误!!");
            model.addAttribute("msg","密码错误");
            return "redirect:/admin";
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/admin";
    }

}
