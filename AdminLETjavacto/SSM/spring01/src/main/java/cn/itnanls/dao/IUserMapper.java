package cn.itnanls.dao;

import cn.itnanls.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Mapper
public interface IUserMapper {

    User findUserById(Integer id);

    User UserById(Integer id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);
    /**
     * 新增user
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 获取所有的用户
     * @return
     */
    List<User> getAllUsers();

}
