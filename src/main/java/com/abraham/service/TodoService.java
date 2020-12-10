package com.abraham.service;

import com.abraham.entity.Todo;

import java.util.List;

/**
 * 待办表(Todo)表服务接口
 *
 * @author makejava
 * @since 2020-11-27 16:56:32
 */
public interface TodoService {

    /**
     * 通过ID查询单条数据
     *
     * @param todoId 主键
     * @return 实例对象
     */
    Todo queryById(Long todoId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Todo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param todo 实例对象
     * @return 实例对象
     */
    Todo insert(Todo todo);

    /**
     * 修改数据
     *
     * @param todo 实例对象
     * @return 实例对象
     */
    Todo update(Todo todo);

    /**
     * 通过主键删除数据
     *
     * @param todoId 主键
     * @return 是否成功
     */
    boolean deleteById(Long todoId);

}