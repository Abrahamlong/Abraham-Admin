package com.abraham.dao;

import com.abraham.entity.Gallery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 图库表(Gallery)表数据库访问层
 *
 * @author Long
 * @since 2020-11-27 16:55:27
 */
@Mapper
@Repository
public interface GalleryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pictureId 主键
     * @return 实例对象
     */
    Gallery queryById(Long pictureId);

    /**
     * 通过实体作为筛选条件查询所有
     *
     * @param gallery 实例对象
     * @return 对象列表
     */
    List<Gallery> queryAllByCondition(Gallery gallery);

    /**
     * 新增数据
     *
     * @param gallery 实例对象
     * @return 影响行数
     */
    int insert(Gallery gallery);

    /**
     * 修改数据
     *
     * @param gallery 实例对象
     * @return 影响行数
     */
    int update(Gallery gallery);

    /**
     * 通过主键删除数据
     *
     * @param pictureId 主键
     * @return 影响行数
     */
    int deleteById(Long pictureId);

}