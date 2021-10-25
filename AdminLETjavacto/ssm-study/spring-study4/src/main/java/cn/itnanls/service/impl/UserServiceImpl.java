package cn.itnanls.service.impl;

import cn.itnanls.dao.IUserMapper;
import cn.itnanls.entity.User;
import cn.itnanls.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
//@Component
    @Service

public class UserServiceImpl implements IUserService {



    @Resource
   private IUserMapper userMapper;

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }
}

