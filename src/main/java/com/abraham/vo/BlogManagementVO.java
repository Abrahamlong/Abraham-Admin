package com.abraham.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: 博客管理列表展示及新增编辑博客展示所需实体类
 *
 * @author: Long
 * @date Create in 16:21 2020/12/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogManagementVO {
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
