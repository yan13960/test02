package cn.itnanls.service.impl;

import cn.itnanls.Annotation.AutoWird;
import cn.itnanls.Annotation.Bean;
import cn.itnanls.dao.IUserDao;
import cn.itnanls.dao.impl.UserDaoImpl;
import cn.itnanls.entity.User;
import cn.itnanls.service.IUserService;

/**
 *
 */
@Bean
public class IUserServiceImpl implements IUserService {
@AutoWird
 private  IUserDao userDao;
@Override
    public void login() {
        userDao.findUserByUserName();

        System.out.println("登录实现方法");
    }

    @Override
    public void regist() {
        userDao.saveUser(new User("1","12","123",12));
        System.out.println("注册业务的实现方法");
    }
}
