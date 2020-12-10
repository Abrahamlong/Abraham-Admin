package com.abraham.service.impl;

import com.abraham.dao.GalleryDao;
import com.abraham.entity.Gallery;
import com.abraham.service.GalleryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图库表(Gallery)表服务实现类
 *
 * @author makejava
 * @since 2020-11-27 16:55:27
 */
@Service("galleryService")
public class GalleryServiceImpl implements GalleryService {
    @Resource
    private GalleryDao galleryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pictureId 主键
     * @return 实例对象
     */
    @Override
    public Gallery queryById(Long pictureId) {
        return this.galleryDao.queryById(pictureId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Gallery> queryAllByLimit(int offset, int limit) {
        return this.galleryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param gallery 实例对象
     * @return 实例对象
     */
    @Override
    public Gallery insert(Gallery gallery) {
        this.galleryDao.insert(gallery);
        return gallery;
    }

    /**
     * 修改数据
     *
     * @param gallery 实例对象
     * @return 实例对象
     */
    @Override
    public Gallery update(Gallery gallery) {
        this.galleryDao.update(gallery);
        return this.queryById(gallery.getPictureId());
    }

    /**
     * 通过主键删除数据
     *
     * @param pictureId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long pictureId) {
        return this.galleryDao.deleteById(pictureId) > 0;
    }
}