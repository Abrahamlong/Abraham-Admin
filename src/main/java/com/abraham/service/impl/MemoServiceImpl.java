package com.abraham.service.impl;

import com.abraham.dao.MemoDao;
import com.abraham.entity.Memo;
import com.abraham.service.MemoService;
import com.abraham.utils.CurrentDateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 备忘录表(Memo)表服务实现类
 *
 * @author Long
 * @since 2020-11-27 16:55:46
 */
@Service("memoService")
public class MemoServiceImpl implements MemoService {
    @Resource
    private MemoDao memoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param memoId 主键
     * @return 实例对象
     */
    @Override
    public Memo queryById(Long memoId) {
        return this.memoDao.queryById(memoId);
    }

    /**
     * 根据条件查询所有符合条件的数据
     *
     * @param memo 实例对象
     * @return 示例对象列表
     */
    @Override
    public List<Memo> queryAllByCondition(Memo memo) {
        return this.memoDao.queryAll(memo);
    }

    /**
     * 新增数据
     *
     * @param memo 实例对象
     * @return 实例对象
     */
    @Override
    public Memo insert(Memo memo) {
        memo.setDeleteFlag(0);
        memo.setGmtCreate(new CurrentDateUtils().getCurrentDate());
        memo.setGmtModified(new CurrentDateUtils().getCurrentDate());
        this.memoDao.insert(memo);
        return memo;
    }

    /**
     * 修改数据
     *
     * @param memo 实例对象
     * @return 实例对象
     */
    @Override
    public Memo update(Memo memo) {
        memo.setGmtModified(new CurrentDateUtils().getCurrentDate());
        this.memoDao.update(memo);
        return this.queryById(memo.getMemoId());
    }

    /**
     * 更新备忘录的状态
     *
     * @param memoId 备忘录Id
     * @param status 备忘录状态
     * @return 影响的记录数
     */
    @Override
    public int updateStatusById(Long memoId, Integer status) {
        Memo memo = new Memo();
        memo.setMemoId(memoId);
        memo.setMemoStatus(status);
        return memoDao.update(memo);
    }

    /**
     * 通过主键删除数据
     *
     * @param memoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long memoId) {
        return this.memoDao.deleteById(memoId) > 0;
    }
}