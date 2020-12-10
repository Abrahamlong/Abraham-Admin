package com.abraham.service;

import com.abraham.entity.Blog;
import com.abraham.vo.BlogManagementVO;

import java.util.List;

/**
 * 博客表(Blog)表服务接口
 *
 * @author Long
 * @since 2020-11-27 16:51:28
 */
public interface BlogService {

    /**
     * 通过ID查询单条数据(后台博客管理)
     *
     * @param blogId 主键
     * @return 实例对象
     */
    Blog queryById(Long blogId);

    /**
     * 通过BlogManagementVO实体作为筛选条件查询多条数据(后台博客管理)
     *
     * @param blogManagementVO 实体对象
     * @return 对象列表
     */
    List<BlogManagementVO> queryAllByCondition(BlogManagementVO blogManagementVO);

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    Blog insert(Blog blog);

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    Blog update(Blog blog);

    /**
     * 通过主键删除数据
     *
     * @param blogId 主键
     * @return 是否成功
     */
    boolean deleteById(Long blogId);

}