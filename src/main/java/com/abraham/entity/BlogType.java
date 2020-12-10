package com.abraham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客类型表(BlogType)实体类
 *
 * @author makejava
 * @since 2020-11-27 16:53:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BlogType implements Serializable {
    private static final long serialVersionUID = -94719966281946234L;
    /**
     * 博客类型Id
     */
    private Long typeId;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 博客数量
     */
    private Integer blogCount;
    /**
     * 文件数量
     */
    private Integer fileCount;
    /**
     * 博客类型状态，0-未启用，1-已启用
     */
    private Integer typeStatus;
    /**
     * 创建博客类型用户Id
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