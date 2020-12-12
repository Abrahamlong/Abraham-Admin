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
    BlogManagementVO queryById(Long blogId);

    /**
     * 通过博客标题查询单条数据(后台博客管理)
     *
     * @param blogTitle 博客标题
     * @return 实例对象
     */
    Boolean queryByTitle(String blogTitle);

    /**
     * 通过BlogManagementVO实体查询所有数据(后台博客管理)
     *
     * @return 对象列表
     */
    List<BlogManagementVO> queryAll();

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
     * @return 影响的行数
     */
    int insert(Blog blog);

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 影响的行数
     */
    int update(Blog blog);

    /**
     * 根据ID更新博客发布状态
     *
     * @param blogId 博客Id
     * @param published 要更新的发布状态
     * @return 影响的行数
     */
    int updatePublished(Long blogId, Integer published);


    /**
     * 通过主键删除数据
     *
     * @param blogId 主键
     * @return 是否成功
     */
    boolean deleteById(Long blogId);

}