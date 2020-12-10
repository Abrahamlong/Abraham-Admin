package com.abraham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户-角色表(UserRole)实体类
 *
 * @author long
 * @since 2020-11-27 16:58:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserRole implements Serializable {
    private static final long serialVersionUID = 935626318896791036L;
    /**
     * 自增Id
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 操作用户Id
     */
    private Long operateUser;
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