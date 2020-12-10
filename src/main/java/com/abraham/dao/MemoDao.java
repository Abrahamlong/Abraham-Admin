package com.abraham.dao;

import com.abraham.entity.Memo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 备忘录表(Memo)表数据库访问层
 *
 * @author Long
 * @since 2020-11-27 16:55:46
 */
@Mapper
@Repository
public interface MemoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param memoId 主键
     * @return 实例对象
     */
    Memo queryById(Long memoId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param memo 实例对象
     * @return 对象列表
     */
    List<Memo> queryAll(Memo memo);

    /**
     * 新增数据
     *
     * @param memo 实例对象
     * @return 影响行数
     */
    int insert(Memo memo);

    /**
     * 修改数据
     *
     * @param memo 实例对象
     * @return 影响行数
     */
    int update(Memo memo);

    /**
     * 通过主键删除数据
     *
     * @param memoId 主键
     * @return 影响行数
     */
    int deleteById(Long memoId);

}