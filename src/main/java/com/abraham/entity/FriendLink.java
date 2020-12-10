package com.abraham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 友链表(FriendLink)实体类
 *
 * @author long
 * @since 2020-11-27 16:55:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FriendLink implements Serializable {
    private static final long serialVersionUID = 660973936579956791L;
    /**
     * 友链Id
     */
    private Long friendLinkId;
    /**
     * 博客地址(url)
     */
    private String blogAddress;
    /**
     * 博客名称
     */
    private String blogName;
    /**
     * 图片链接
     */
    private String pictureAddress;
    /**
     * 友链状态，0-未开启，1-已开启
     */
    private Integer friendStatus;
    /**
     * 创建友链用户Id
     */
    private Long createUser;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 是否删除，0-不删除，1-删除
     */
    private Integer deleteFlag;
}