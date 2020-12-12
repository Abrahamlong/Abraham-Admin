package com.abraham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客表(Blog)实体类
 *
 * @author Long
 * @since 2020-11-27 16:51:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Blog implements Serializable {
    private static final long serialVersionUID = 887848155669106205L;
    /**
     * 博客Id
     */
    private Long blogId;
    /**
     * 博客标题
     */
    private String blogTitle;
    /**
     * 创作类型，0-原创，1-转载，2-翻译，3-随笔
     */
    private Integer creationType;
    /**
     * 类型Id，表示博客所属类型
     */
    private Long typeId;
    /**
     * 博客首图
     */
    private String firstPicture;
    /**
     * 博客内容
     */
    private String blogContent;
    /**
     * 博客描述
     */
    private String blogDescription;
    /**
     * 标签
     */
    private String label;
    /**
     * 是否发布，0-不发布，1-已发布
     */
    private Integer published;
    /**
     * 是否开启赞赏，0-不开启赞赏，1-开启赞赏
     */
    private Integer commendable;
    /**
     * 是否推荐，0-不推荐，1-推荐
     */
    private Integer recommend;
    /**
     * 浏览数量
     */
    private Integer viewsCount;
    /**
     * 评论数量
     */
    private Integer commentCount;
    /**
     * 收藏数量
     */
    private Integer collectCount;
    /**
     * 赞赏数量
     */
    private Integer commendableCount;
    /**
     * 创建博客用户Id
     */
    private Long createUser;
    /**
     * 创建时间
     */
    private String gmtCreate;
    /**
     * 更新时间
     */
    private String gmtModified;
    /**
     * 是否删除，0-不删除，1-删除
     */
    private Integer deleteFlag;

}