package cn.itnanls.service;

import cn.itnanls.entity.User;

/**
 *
 */
public interface IUserService {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User  findUserById(Integer id);
}

