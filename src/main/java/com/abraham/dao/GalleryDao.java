package com.abraham.dao;

import com.abraham.entity.Gallery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 图库表(Gallery)表数据库访问层
 *
 * @author makejava
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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Gallery> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param gallery 实例对象
     * @return 对象列表
     */
    List<Gallery> queryAll(Gallery gallery);

    /**
     * 新增数据
     *
     * @param gallery 实例对象
     * @return 影响行数
     */
    int insert(Gallery gallery);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Gallery> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Gallery> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Gallery> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Gallery> entities);

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