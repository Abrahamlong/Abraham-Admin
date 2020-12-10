package com.abraham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 图库表(Gallery)实体类
 *
 * @author long
 * @since 2020-11-27 16:55:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Gallery implements Serializable {
    private static final long serialVersionUID = -76434188553433619L;
    /**
     * 图片Id
     */
    private Long pictureId;
    /**
     * 图片地址
     */
    private String pictureAddress;
    /**
     * 图片名称
     */
    private String pictureName;
    /**
     * 图片描述
     */
    private String pictureDescription;
    /**
     * 图片类型，0-相册，1-博客，2-背景，3-头像，4-友链
     */
    private Integer pictureType;
    /**
     * 被使用数量
     */
    private Integer useCount;
    /**
     * 新增图片用户Id
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