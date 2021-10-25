package com.javacto.service;

import com.javacto.po.Role;
import com.javacto.po.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
public interface UserService extends UserDetailsService {
    public List<UserInfo> queryAll();
    public  void insert(UserInfo info);
    /**
     * 根据id查询用户信息
     */
    public UserInfo findById(String userId);

    //查询可以添加的用户权限
    public List<Role> findOtherRoles(String userId);
    //添加权限
    public void addRoleToUser(String userId, String[] roleIds);

}
