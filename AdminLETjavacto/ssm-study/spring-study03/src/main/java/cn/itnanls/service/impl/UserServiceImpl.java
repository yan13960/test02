package cn.itnanls.service.impl;

import cn.itnanls.Annotation.LogAnnotation;
import cn.itnanls.dao.IUserDao;
import cn.itnanls.entity.User;
import cn.itnanls.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
//@Component
    @Service

public class UserServiceImpl implements IUserService {

    /*IUserDao UserDao =new UserDaoImpl();*/
    @Resource
    private IUserDao userDao;

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */

    @Override

    public User findUserById(Integer id) {
       // int i=1/0;
        System.out.println("方法在执行");
        return userDao.findUserById(id);
    }
}
