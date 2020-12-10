package com.abraham.service;

import com.abraham.entity.Memo;

import java.util.List;

/**
 * 备忘录表(Memo)表服务接口
 *
 * @author Long
 * @since 2020-11-27 16:55:46
 */
public interface MemoService {

    /**
     * 通过ID查询单条数据
     *
     * @param memoId 主键
     * @return 实例对象
     */
    Memo queryById(Long memoId);

    /**
     * 根据条件查询所有符合条件的数据
     *
     * @param memo 实例对象
     * @return 示例对象列表
     */
    List<Memo> queryAllByCondition(Memo memo);

    /**
     * 新增数据
     *
     * @param memo 实例对象
     * @return 实例对象
     */
    Memo insert(Memo memo);

    /**
     * 修改数据
     *
     * @param memo 实例对象
     * @return 实例对象
     */
    Memo update(Memo memo);

    /**
     * 更新备忘录的状态
     *
     * @param memoId 备忘录Id
     * @param status 备忘录状态
     * @return 影响的记录数
     */
    int updateStatusById(Long memoId, Integer status);

    /**
     * 通过主键删除数据
     *
     * @param memoId 主键
     * @return 是否成功
     */
    boolean deleteById(Long memoId);

}