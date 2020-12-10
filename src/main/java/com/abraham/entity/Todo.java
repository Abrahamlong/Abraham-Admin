package com.abraham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 待办表(Todo)实体类
 *
 * @author long
 * @since 2020-11-27 16:56:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Todo implements Serializable {
    private static final long serialVersionUID = 697044057753513458L;
    /**
     * 待办事项Id
     */
    private Long todoId;
    /**
     * 待办事项标题
     */
    private String todoTitle;
    /**
     * 待办事项描述
     */
    private String todoDescription;
    /**
     * 待办事项状态，0-未完成，1-已完成，2-超时
     */
    private Integer todoStatus;
    /**
     * 截止时间
     */
    private Date deadline;
    /**
     * 创建待办事项用户Id
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