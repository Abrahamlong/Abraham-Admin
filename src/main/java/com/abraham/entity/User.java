package com.abraham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表(User)实体类
 *
 * @author long
 * @since 2020-11-27 16:58:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User implements Serializable {
    private static final long serialVersionUID = -80052096211965017L;
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
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别，0-男，1-女
     */
    private Integer gender;
    /**
     * 生日，格式为: yyyy-MM-dd
     */
    private Date birth;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 学校
     */
    private String school;
    /**
     * 专业
     */
    private String professional;
    /**
     * 毕业时间，格式为: yyyy-MM-dd
     */
    private Date graduationTime;
    /**
     * 工作
     */
    private String work;
    /**
     * 职位
     */
    private String position;
    /**
     * 工作时间，格式为: yyyy-MM-dd
     */
    private Date workTime;
    /**
     * 擅长技能
     */
    private String skills;
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