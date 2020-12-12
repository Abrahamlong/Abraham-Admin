package com.abraham.service.impl;

import com.abraham.dao.FriendLinkDao;
import com.abraham.entity.FriendLink;
import com.abraham.service.FriendLinkService;
import com.abraham.utils.CurrentDateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 友链表(FriendLink)表服务实现类
 *
 * @author makejava
 * @since 2020-11-27 16:55:08
 */
@Service("friendLinkService")
public class FriendLinkServiceImpl implements FriendLinkService {
    @Resource
    private FriendLinkDao friendLinkDao;

    /**
     * 通过ID查询单条数据
     *
     * @param friendLinkId 主键
     * @return 实例对象
     */
    @Override
    public FriendLink queryById(Long friendLinkId) {
        return this.friendLinkDao.queryById(friendLinkId);
    }

    /**
     * 根据条件查询多条数据
     *
     * @param friendLink 实体对象
     * @return 对象列表
     */
    @Override
    public List<FriendLink> queryAllByCondition(FriendLink friendLink) {
        return this.friendLinkDao.queryAllByCondition(friendLink);
    }

    /**
     * 新增数据
     *
     * @param friendLink 实例对象
     * @return 影响行数
     */
    @Override
    public int insert(FriendLink friendLink) {
        friendLink.setGmtCreate(new CurrentDateUtils().getCurrentDate());
        friendLink.setGmtModified(new CurrentDateUtils().getCurrentDate());
        friendLink.setDeleteFlag(0);
        return this.friendLinkDao.insert(friendLink);
    }

    /**
     * 修改数据
     *
     * @param friendLink 实例对象
     * @return 影响行数
     */
    @Override
    public int update(FriendLink friendLink) {
        friendLink.setGmtModified(new CurrentDateUtils().getCurrentDate());
        return this.friendLinkDao.update(friendLink);
    }

    /**
     * 根据友链Id更新其状态值
     *
     * @param friendLinkId 友链Id
     * @param status 友链状态
     * @return 影响行数
     */
    @Override
    public int updateStatus(Long friendLinkId, Integer status) {
        FriendLink friendLink = new FriendLink();
        friendLink.setFriendLinkId(friendLinkId);
        friendLink.setFriendStatus(status);
        return this.friendLinkDao.update(friendLink);
    }

    /**
     * 通过主键删除数据
     *
     * @param friendLinkId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long friendLinkId) {
        return this.friendLinkDao.deleteById(friendLinkId) > 0;
    }
}