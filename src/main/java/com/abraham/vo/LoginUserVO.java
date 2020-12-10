package com.abraham.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: 用户登录功能所需的用户实体类
 *
 * @author: Long
 * @date Create in 14:14 2020/12/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVO {
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户状态，0-禁用(锁定)，1-正常
     */
    private Integer userStatus;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 最后登录时间
     */
    private Date finallyLoginTime;
    /**
     * 是否删除，0-不删除，1-删除
     */
    private Integer deleteFlag;
}
