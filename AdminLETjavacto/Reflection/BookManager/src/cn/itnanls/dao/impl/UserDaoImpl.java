package cn.itnanls.dao.impl;

import cn.itnanls.Annotation.Bean;
import cn.itnanls.dao.IUserDao;
import cn.itnanls.entity.User;

import java.util.List;

/**
 *
 */

public class UserDaoImpl implements IUserDao {
    @Override
    public User findUserById(int id) {
        System.out.println("这里是dao—findUserById");
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        System.out.println("这里是dao—findAllUsers");
        return null;
    }

    @Override
    public List<User> findUserByUserName() {
        System.out.println("这里是dao—findUserByUserName");
        return null;
    }

    @Override
    public void saveUser(User user) {
        System.out.println("这里是dao—saveUser");
    }
}
