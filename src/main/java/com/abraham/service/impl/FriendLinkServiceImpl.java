package com.abraham.service.impl;

import com.abraham.dao.FriendLinkDao;
import com.abraham.entity.FriendLink;
import com.abraham.service.FriendLinkService;
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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<FriendLink> queryAllByLimit(int offset, int limit) {
        return this.friendLinkDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param friendLink 实例对象
     * @return 实例对象
     */
    @Override
    public FriendLink insert(FriendLink friendLink) {
        this.friendLinkDao.insert(friendLink);
        return friendLink;
    }

    /**
     * 修改数据
     *
     * @param friendLink 实例对象
     * @return 实例对象
     */
    @Override
    public FriendLink update(FriendLink friendLink) {
        this.friendLinkDao.update(friendLink);
        return this.queryById(friendLink.getFriendLinkId());
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