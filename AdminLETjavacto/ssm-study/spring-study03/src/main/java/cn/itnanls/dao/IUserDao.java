package cn.itnanls.dao;

import cn.itnanls.entity.User;

/**
 *
 */
public interface IUserDao {
    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User  findUserById(Integer id);
}
