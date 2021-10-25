package com.javacto.service;

import com.javacto.po.Permission;
import com.javacto.po.Role;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
public interface RoleService {
    public List<Role> queryAll();
    public  void insert(Role role);


    //查询可以添加的资源权限
    public List<Permission> findOtherPermissions(String roleId);

    //添加的资源权限
    public void addPermissionToRole(String roleId, String[] permissionIds);
}
