package cn.itnanls.service;

import cn.itnanls.entity.User;
import org.springframework.stereotype.Component;

/**
 *
 */

public interface IUserService {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User findUserById(Integer id);

    User UserById(Integer id);


}

