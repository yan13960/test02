package cn.itnanls.service.impl;

import cn.itnanls.Annotation.LogAnnotation;
import cn.itnanls.dao.IUserMapper;
import cn.itnanls.entity.User;
import cn.itnanls.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 */
//@Component
    @Service
//@Transactional  //在新的spring版本当中，只要配置了自动事务管理，这个注解可加可不加
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
        int addUser = userMapper.addUser(new User(115, "a", "b",null));
        System.out.println(addUser);
        int i =1/0;
        int updateUser = userMapper.updateUser(new User(115, "c", "b",null));
        System.out.println(updateUser);
        return  null ;
    }

     @Transactional(propagation = Propagation.REQUIRED)
    public User UserById(Integer id) {
        int addUser = userMapper.addUser(new User(117, "a", "b",null));
        System.out.println(addUser);
        int i =1/0;
        int updateUser = userMapper.updateUser(new User(117, "c", "b",null));
        System.out.println(updateUser);
        return  null ;
    }


}

