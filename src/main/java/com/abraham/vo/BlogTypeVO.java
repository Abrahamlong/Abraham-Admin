package com.abraham.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Description: 新增文章中博客类型选项展示实体类
 * @author: Long
 * @date Create in 15:03 2020/12/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BlogTypeVO {
    /**
     * 博客类型Id
     */
    private Long typeId;
    /**
     * 类型名称
     */
    private String typeName;
}
