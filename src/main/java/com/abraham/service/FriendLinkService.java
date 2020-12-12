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
     * 根据条件查询多条数据
     *
     * @param friendLink 实体对象
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
     * 根据友链Id更新其状态值
     *
     * @param friendLinkId 友链Id
     * @param status 友链状态
     * @return 影响行数
     */
    int updateStatus(Long friendLinkId, Integer status);

    /**
     * 通过主键删除数据
     *
     * @param friendLinkId 主键
     * @return 是否成功
     */
    boolean deleteById(Long friendLinkId);

}