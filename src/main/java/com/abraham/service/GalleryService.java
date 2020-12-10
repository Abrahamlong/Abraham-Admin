package com.abraham.service;

import com.abraham.entity.Gallery;

import java.util.List;

/**
 * 图库表(Gallery)表服务接口
 *
 * @author makejava
 * @since 2020-11-27 16:55:27
 */
public interface GalleryService {

    /**
     * 通过ID查询单条数据
     *
     * @param pictureId 主键
     * @return 实例对象
     */
    Gallery queryById(Long pictureId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Gallery> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param gallery 实例对象
     * @return 实例对象
     */
    Gallery insert(Gallery gallery);

    /**
     * 修改数据
     *
     * @param gallery 实例对象
     * @return 实例对象
     */
    Gallery update(Gallery gallery);

    /**
     * 通过主键删除数据
     *
     * @param pictureId 主键
     * @return 是否成功
     */
    boolean deleteById(Long pictureId);

}