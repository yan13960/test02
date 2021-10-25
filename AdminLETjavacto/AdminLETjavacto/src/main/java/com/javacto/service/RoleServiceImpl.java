package com.javacto.service;

import com.javacto.mapper.RoleMapper;
import com.javacto.po.Permission;
import com.javacto.po.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    public List<Role> queryAll(){
       return roleMapper.queryAll();
    }
    public  void insert(Role role){
        roleMapper.insert(role);
    }


    //查询可以添加的资源权限
    public List<Permission> findOtherPermissions(String roleId){
        return roleMapper.findOtherPermissions(roleId);
    }
    //添加的资源权限
    public void addPermissionToRole( String roleId,String[] permissionIds){
        for (String permissionId:permissionIds){
            roleMapper.addPermissionToRole(roleId,permissionId);
        }

    }
}
