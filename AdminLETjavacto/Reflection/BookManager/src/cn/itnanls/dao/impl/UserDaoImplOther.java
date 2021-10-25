package cn.itnanls.dao.impl;

import cn.itnanls.Annotation.Bean;
import cn.itnanls.dao.IUserDao;
import cn.itnanls.entity.User;

import java.util.List;

/**
 *
 */
@Bean
public class UserDaoImplOther implements IUserDao {
    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public List<User> findUserByUserName() {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }
}
