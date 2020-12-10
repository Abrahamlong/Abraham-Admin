package com.abraham.dao;

import com.abraham.entity.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 待办表(Todo)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-27 16:56:32
 */
@Mapper
@Repository
public interface TodoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param todoId 主键
     * @return 实例对象
     */
    Todo queryById(Long todoId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Todo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param todo 实例对象
     * @return 对象列表
     */
    List<Todo> queryAll(Todo todo);

    /**
     * 新增数据
     *
     * @param todo 实例对象
     * @return 影响行数
     */
    int insert(Todo todo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Todo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Todo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Todo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Todo> entities);

    /**
     * 修改数据
     *
     * @param todo 实例对象
     * @return 影响行数
     */
    int update(Todo todo);

    /**
     * 通过主键删除数据
     *
     * @param todoId 主键
     * @return 影响行数
     */
    int deleteById(Long todoId);

}