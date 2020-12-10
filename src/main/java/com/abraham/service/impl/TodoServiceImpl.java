package com.abraham.service.impl;

import com.abraham.dao.TodoDao;
import com.abraham.entity.Todo;
import com.abraham.service.TodoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 待办表(Todo)表服务实现类
 *
 * @author makejava
 * @since 2020-11-27 16:56:32
 */
@Service("todoService")
public class TodoServiceImpl implements TodoService {
    @Resource
    private TodoDao todoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param todoId 主键
     * @return 实例对象
     */
    @Override
    public Todo queryById(Long todoId) {
        return this.todoDao.queryById(todoId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Todo> queryAllByLimit(int offset, int limit) {
        return this.todoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param todo 实例对象
     * @return 实例对象
     */
    @Override
    public Todo insert(Todo todo) {
        this.todoDao.insert(todo);
        return todo;
    }

    /**
     * 修改数据
     *
     * @param todo 实例对象
     * @return 实例对象
     */
    @Override
    public Todo update(Todo todo) {
        this.todoDao.update(todo);
        return this.queryById(todo.getTodoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param todoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long todoId) {
        return this.todoDao.deleteById(todoId) > 0;
    }
}