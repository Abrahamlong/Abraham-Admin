package com.abraham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 备忘录表(Memo)实体类
 *
 * @author long
 * @since 2020-11-27 16:55:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Memo implements Serializable {
    private static final long serialVersionUID = -45096563110695821L;
    /**
     * 备忘录Id
     */
    private Long memoId;
    /**
     * 备忘录标题
     */
    private String memoTitle;
    /**
     * 备忘录内容
     */
    private String memoContent;
    /**
     * 备忘录状态，0-未完成，1-已完成
     */
    private Integer memoStatus;
    /**
     * 创建备忘录用户Id
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