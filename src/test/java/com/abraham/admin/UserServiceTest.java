package com.abraham.admin;

import com.abraham.service.UserService;
import com.abraham.vo.LoginUserVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Description: 用户service测试类
 * @author: Long
 * @date Create in 14:44 2020/12/1
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testCheckLoginUser(){
        LoginUserVO loginUser = userService.checkLoginUser("abraham");
        System.out.println(loginUser);
    }
}
