package com.abraham.service.impl;

import com.abraham.dao.BlogDao;
import com.abraham.entity.Blog;
import com.abraham.service.BlogService;
import com.abraham.utils.CurrentDateUtils;
import com.abraham.vo.BlogManagementVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客表(Blog)表服务实现类
 *
 * @author long
 * @since 2020-11-27 16:51:28
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogDao blogDao;

    /**
     * 通过ID查询单条数据(后台博客管理)
     *
     * @param blogId 主键
     * @return 实例对象
     */
    @Override
    public BlogManagementVO queryById(Long blogId) {
        return this.blogDao.queryById(blogId);
    }

    /**
     * 通过博客标题查询单条数据(后台博客管理)
     *
     * @param blogTitle 博客标题
     * @return 实例对象
     */
    public Boolean queryByTitle(String blogTitle) {
        Blog blog = this.blogDao.queryByTitle(blogTitle);
        return blog != null;
    }

    /**
     * 通过BlogManagementVO实体查询所有数据(后台博客管理)
     *
     * @return 对象列表
     */
    @Override
    public List<BlogManagementVO> queryAll() {
        return this.blogDao.queryAll();
    }

    /**
     * 通过BlogManagementVO实体作为筛选条件查询多条数据(后台博客管理)
     *
     * @param blogManagementVO 实体对象
     * @return 对象列表
     */
    @Override
    public List<BlogManagementVO> queryAllByCondition(BlogManagementVO blogManagementVO) {
        return this.blogDao.queryAllByCondition(blogManagementVO);
    }

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Blog blog) {
        blog.setViewsCount(0);
        blog.setCollectCount(0);
        blog.setCommentCount(0);
        blog.setCommendableCount(0);
        blog.setGmtCreate(new CurrentDateUtils().getCurrentDate());
        blog.setGmtModified(new CurrentDateUtils().getCurrentDate());
        blog.setDeleteFlag(0);
        return this.blogDao.insert(blog);
    }

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Blog blog) {
        return this.blogDao.update(blog);
    }

    /**
     * 根据ID更新博客发布状态
     *
     * @param blogId 博客Id
     * @param published 要更新的发布状态
     * @return 影响的行数
     */
    @Override
    public int updatePublished(Long blogId, Integer published) {
        Blog blog = new Blog();
        blog.setBlogId(blogId);
        blog.setPublished(published);
        return this.blogDao.update(blog);
    }

    /**
     * 通过主键删除数据
     *
     * @param blogId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long blogId) {
        return this.blogDao.deleteById(blogId) > 0;
    }
}