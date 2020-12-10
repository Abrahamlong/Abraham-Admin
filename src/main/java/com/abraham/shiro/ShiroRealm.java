package com.abraham.shiro;

import com.abraham.service.UserService;
import com.abraham.vo.LoginUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

/**
 * @Description:
 * @author: Long
 * @date Create in 16:27 2020/12/1
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        LoginUserVO user = userService.checkLoginUser(userToken.getUsername());
        if (user != null) {
            if (user.getUserStatus() == 0){
                System.out.println("该账户被锁定!!");
            }
            return new SimpleAuthenticationInfo("",user.getPassword(),"");
        }

        return null;
    }
}
