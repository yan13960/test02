package com.javacto.mapper;

import com.javacto.po.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
public interface PermissionMapper {

    /**
     * 查询所有资源权限信息
     * @return
     */
    @Select("select * from permission")
    public List<Permission> findAll() ;

    /**
     * 添加资源权限信息
     * @param permission
     */
    @Insert("insert into permission(id,permissionName,url) values(#{id},#{permissionName},#{url})")
    public  void save(Permission permission);

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(String id);


}
