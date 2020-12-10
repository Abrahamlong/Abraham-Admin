package com.abraham.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: shiro配置类
 *
 * @author: Long
 * @date Create in 16:22 2020/12/1
 */
@Configuration
public class ShiroConfig {

    /**
     * Filter工厂，设置对应的过滤条件和跳转条件
     * @param securityManager 安全管理器
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /*
            anon: 无需认证就可以访问
            authc: 必须认证才能访问
            user: 必须拥有“记住我”功能才能使用
            perms: 拥有某个资源的权限才能使用
            role: 必须拥有某个角色的权限才能使用
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接
        // filterChainDefinitionMap.put("/static/**", "anon");
        // 配置需要认证之后才能访问的链接
//         filterChainDefinitionMap.put("/admin/todo-list", "authc");
        // 配置登出过滤器
        filterChainDefinitionMap.put("/logout", "logout");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 配置登录链接
        shiroFilterFactoryBean.setLoginUrl("/admin/login");
        // 配置登录成功后跳转的链接
        // shiroFilterFactoryBean.setSuccessUrl("/admin/index");
        // 配置未授权页面
        // shiroFilterFactoryBean.setUnauthorizedUrl("/401");

        return shiroFilterFactoryBean;
    }

    /**
     * 安全管理器，配置主要是Realm的管理认证
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    /**
     * 创建自定义的realm对象
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();

        return shiroRealm;
    }
}
