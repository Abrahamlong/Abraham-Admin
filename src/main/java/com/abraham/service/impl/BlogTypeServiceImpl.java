package com.abraham.service.impl;

import com.abraham.dao.BlogTypeDao;
import com.abraham.entity.BlogType;
import com.abraham.service.BlogTypeService;
import com.abraham.utils.CurrentDateUtils;
import com.abraham.vo.BlogTypeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客类型表(BlogType)表服务实现类
 *
 * @author Long
 * @since 2020-11-27 16:53:45
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
    @Resource
    private BlogTypeDao blogTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public BlogType queryById(Long typeId) {
        return this.blogTypeDao.queryById(typeId);
    }

    /**
     * 通过博客类型名称查询单条数据
     *
     * @param typeName 博客类型名称
     * @return 实例对象
     */
    @Override
    public BlogType queryByName(String typeName) {
        return this.blogTypeDao.queryByName(typeName);
    }

    /**
     * 根据条件查询多条数据
     *
     * @param blogType 实例对象
     * @return 对象列表
     */
    @Override
    public List<BlogType> queryAllByCondition(BlogType blogType) {
        List<BlogType> blogTypes = blogTypeDao.queryAllByCondition(blogType);
        for (BlogType type : blogTypes) {
            type.setGmtCreate(type.getGmtCreate().substring(0,10));
        }
        return blogTypes;
    }

    /**
     * 查询所有数据，仅返回类型id和类型名称（博客新增使用）
     *
     * @return 对象列表
     */
    @Override
    public List<BlogTypeVO> queryAll() {
        return this.blogTypeDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param blogType 实例对象
     * @return 实例对象
     */
    @Override
    public BlogType insert(BlogType blogType) {
        blogType.setDeleteFlag(0);
        blogType.setGmtCreate(new CurrentDateUtils().getCurrentDate());
        blogType.setGmtModified(new CurrentDateUtils().getCurrentDate());
        this.blogTypeDao.insert(blogType);
        return blogType;
    }

    /**
     * 修改数据
     *
     * @param blogType 实例对象
     * @return 实例对象
     */
    @Override
    public BlogType update(BlogType blogType) {
        blogType.setGmtModified(new CurrentDateUtils().getCurrentDate());
        this.blogTypeDao.update(blogType);
        return this.queryById(blogType.getTypeId());
    }

    /**
     * 更新博客类型状态
     *
     * @param typeId 博客类型Id
     * @param status 博客状态
     * @return 实例对象
     */
    @Override
    public int updateStatusById(Long typeId, Integer status) {
        BlogType blogType = new BlogType();
        blogType.setTypeId(typeId);
        blogType.setTypeStatus(status);
        return this.blogTypeDao.update(blogType);
    }

    /**
     * 通过主键删除数据(逻辑删除)
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long typeId) {
        return this.blogTypeDao.deleteById(typeId) > 0;
    }

}