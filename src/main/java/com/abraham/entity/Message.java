package com.abraham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言表(Message)实体类
 *
 * @author long
 * @since 2020-11-27 16:56:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Message implements Serializable {
    private static final long serialVersionUID = 352554244963319129L;
    /**
     * 留言Id
     */
    private Long messageId;
    /**
     * 新增留言用户Id
     */
    private Long createUser;
    /**
     * 目标用户Id
     */
    private Long targetUser;
    /**
     * 留言内容
     */
    private String messageContent;
    /**
     * 父留言Id
     */
    private Long parentMessageId;
    /**
     * 是否回复，0-未回复，1-已回复
     */
    private Integer messageStatus;
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