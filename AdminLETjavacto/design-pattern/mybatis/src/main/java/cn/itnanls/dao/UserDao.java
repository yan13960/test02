package cn.itnanls.dao;

import cn.itnanls.entity.User;

import java.util.List;

/**
 *
 */
public interface UserDao {
    /*
    * 保存用户
    * */

    /**
     *保存用户
     * @param user
     * @return
     */
    Integer saveUser(User user);

    /**
     *根据id查询
     * @param id
     * @return
     */
    List<User> findUser(Integer id);

}
