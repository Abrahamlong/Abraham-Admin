package com.abraham.service;

import com.abraham.entity.User;
import com.abraham.vo.LoginUserVO;

import java.util.List;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2020-11-27 16:58:41
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Long userId);

    /**
     * 通过用户名查询单条数据
     *
     * @param username 主键
     * @return 用户ID
     */
    Long queryByUsername(String username);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 检查登录用户是否存在，且用户名密码是否正确
     *
     * @param username 用户名
     * @return 用户实体
     */
    LoginUserVO checkLoginUser(String username);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

}