package com.abraham.service;

import com.abraham.entity.BlogType;

import java.util.List;

/**
 * 博客类型表(BlogType)表服务接口
 *
 * @author Long
 * @since 2020-11-27 16:53:45
 */
public interface BlogTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    BlogType queryById(Long typeId);

    /**
     * 通过博客类型名称查询单条数据
     *
     * @param typeName 博客类型名称
     * @return 实例对象
     */
    BlogType queryByName(String typeName);

    /**
     * 查询多条数据
     *
     * @param blogType 实例对象
     * @return 对象列表
     */
    List<BlogType> queryAllByCondition(BlogType blogType);

    /**
     * 新增数据
     *
     * @param blogType 实例对象
     * @return 实例对象
     */
    BlogType insert(BlogType blogType);

    /**
     * 修改数据
     *
     * @param blogType 实例对象
     * @return 实例对象
     */
    BlogType update(BlogType blogType);

    /**
     * 更新博客类型状态
     *
     * @param typeId 博客类型Id
     * @param status 博客状态
     * @return 实例对象
     */
    int updateStatusById(Long typeId, Integer status);

    /**
     * 通过主键删除数据(逻辑删除)
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Long typeId);

}