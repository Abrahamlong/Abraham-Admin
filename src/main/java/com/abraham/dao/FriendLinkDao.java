package com.abraham.dao;

import com.abraham.entity.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 友链表(FriendLink)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-27 16:55:07
 */
@Mapper
@Repository
public interface FriendLinkDao {

    /**
     * 通过ID查询单条数据
     *
     * @param friendLinkId 主键
     * @return 实例对象
     */
    FriendLink queryById(Long friendLinkId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param friendLink 实例对象
     * @return 对象列表
     */
    List<FriendLink> queryAllByCondition(FriendLink friendLink);

    /**
     * 新增数据
     *
     * @param friendLink 实例对象
     * @return 影响行数
     */
    int insert(FriendLink friendLink);

    /**
     * 修改数据
     *
     * @param friendLink 实例对象
     * @return 影响行数
     */
    int update(FriendLink friendLink);

    /**
     * 通过主键删除数据
     *
     * @param friendLinkId 主键
     * @return 影响行数
     */
    int deleteById(Long friendLinkId);

}