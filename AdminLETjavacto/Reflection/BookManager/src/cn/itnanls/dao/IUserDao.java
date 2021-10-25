package cn.itnanls.dao;

import cn.itnanls.entity.User;

import java.util.List;

/**
 *
 */
public interface IUserDao {
    /**
     * 根据id找到一个user
     * @param id
     * @return
     */

    User findUserById(int id);

    /**
     * 获取所有的用户
     * @return
     */
   List<User> findAllUsers();

    /**
     * 根据用户名获取用户
     * @return
     */
   List<User> findUserByUserName();

    /**
     * 保存用户
     * @param user
     */
   void  saveUser(User user);
}
