package cn.itnanls.dao.impl;

import cn.itnanls.dao.IUserDao;
import cn.itnanls.entity.User;
import org.springframework.stereotype.Repository;

/**
 *
 */
//@Component
@Repository
public class UserDaoImpl  implements IUserDao {
    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(Integer id) {
        return new User("lucy",12);
    }
}
