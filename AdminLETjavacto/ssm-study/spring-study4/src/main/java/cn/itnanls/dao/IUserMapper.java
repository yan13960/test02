package cn.itnanls.dao;

import cn.itnanls.entity.User;
import org.springframework.stereotype.Component;

/**
 *
 */

public interface IUserMapper {

    User findUserById(Integer id);
}
