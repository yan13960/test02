package cn.itnanls.service.impl;

import cn.itnanls.dao.IUserDao;
import cn.itnanls.entity.User;
import cn.itnanls.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
//@Component
    @Service
public class UserServiceImpl implements IUserService {

    /*IUserDao UserDao =new UserDaoImpl();*/
    @Autowired
    private IUserDao userDao;

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }
}
