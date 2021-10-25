package cn.itnanls.dao;

import cn.itnanls.entity.User;

import java.util.List;

/**
 *
 */
public interface StudentDao {
    /**
     *保存用户
     * @param user
     * @return
     */
    Integer saveStudent(User user);

    /**
     *根据id查询
     * @param id
     * @return
     */
    List<User> findStudent(Integer id);

}

