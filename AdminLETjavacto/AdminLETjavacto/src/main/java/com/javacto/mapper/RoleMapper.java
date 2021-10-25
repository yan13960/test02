package com.javacto.mapper;

import com.javacto.po.Permission;
import com.javacto.po.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
public interface RoleMapper {
    @Select("SELECT * FROM role")
    public List<Role> queryAll();
    @Insert("insert into role(id,roleName,roleDesc) values(#{id},#{roleName},#{roleDesc})")
    public  void insert(Role role);

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",
                    many = @Many(select = "com.javacto.mapper.PermissionMapper.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId);


    //查询可以添加的资源权限
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);
    //添加的资源权限
    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);



}
