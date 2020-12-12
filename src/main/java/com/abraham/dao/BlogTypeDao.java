package com.abraham.dao;

import com.abraham.entity.BlogType;
import com.abraham.vo.BlogTypeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客类型表(BlogType)表数据库访问层
 *
 * @author Long
 * @since 2020-11-27 16:53:45
 */
@Mapper
@Repository
public interface BlogTypeDao {

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
     * 通过实体作为筛选条件查询
     *
     * @param blogType 实例对象
     * @return 对象列表
     */
    List<BlogType> queryAllByCondition(BlogType blogType);

    /**
     * 查询所有数据，仅返回类型id和类型名称（博客新增使用）
     *
     * @return 对象列表
     */
    List<BlogTypeVO> queryAll();

    /**
     * 新增数据
     *
     * @param blogType 实例对象
     * @return 影响行数
     */
    int insert(BlogType blogType);

    /**
     * 修改数据
     *
     * @param blogType 实例对象
     * @return 影响行数
     */
    int update(BlogType blogType);

    /**
     * 通过主键删除数据(逻辑删除)
     *
     * @param typeId 主键
     * @return 影响行数
     */
    int deleteById(Long typeId);

}