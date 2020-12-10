package com.abraham.service.impl;

import com.abraham.dao.BlogDao;
import com.abraham.entity.Blog;
import com.abraham.service.BlogService;
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
    public Blog queryById(Long blogId) {
        return this.blogDao.queryById(blogId);
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
    public Blog insert(Blog blog) {
        this.blogDao.insert(blog);
        return blog;
    }

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public Blog update(Blog blog) {
        this.blogDao.update(blog);
        return this.queryById(blog.getBlogId());
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