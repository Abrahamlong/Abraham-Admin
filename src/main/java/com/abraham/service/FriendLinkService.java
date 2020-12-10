package com.abraham.service;

import com.abraham.entity.FriendLink;

import java.util.List;

/**
 * 友链表(FriendLink)表服务接口
 *
 * @author makejava
 * @since 2020-11-27 16:55:08
 */
public interface FriendLinkService {

    /**
     * 通过ID查询单条数据
     *
     * @param friendLinkId 主键
     * @return 实例对象
     */
    FriendLink queryById(Long friendLinkId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<FriendLink> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param friendLink 实例对象
     * @return 实例对象
     */
    FriendLink insert(FriendLink friendLink);

    /**
     * 修改数据
     *
     * @param friendLink 实例对象
     * @return 实例对象
     */
    FriendLink update(FriendLink friendLink);

    /**
     * 通过主键删除数据
     *
     * @param friendLinkId 主键
     * @return 是否成功
     */
    boolean deleteById(Long friendLinkId);

}