package com.abraham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客评论表(Comment)实体类
 *
 * @author long
 * @since 2020-11-27 16:54:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Comment implements Serializable {
    private static final long serialVersionUID = 111657626349639252L;
    /**
     * 评论Id
     */
    private Long commentId;
    /**
     * 所属博客Id
     */
    private Long blogId;
    /**
     * 创建评论用户Id
     */
    private Long createUser;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 父评论Id
     */
    private Long parentCommentId;
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