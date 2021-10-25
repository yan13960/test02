package cn.itnanls.dao.impl;

import cn.itnanls.dao.IUserMapper;
import cn.itnanls.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
//SqlSessionDaoSupport里面包含了 SqlSessionTemplate
public class UserMapperImpl extends SqlSessionDaoSupport implements IUserMapper {


    @Override
    public User findUserById(Integer id) {
        IUserMapper mapper = getSqlSessionTemplate().getMapper(IUserMapper.class);
        System.out.println("impl");
        return mapper.findUserById(id);

    }

    @Override
    public User UserById(Integer id) {
        return null;
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        return 0;
    }

    /**
     * 新增user
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return 0;
    }

    /**
     * 获取所有的用户
     *
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return null;
    }

}
