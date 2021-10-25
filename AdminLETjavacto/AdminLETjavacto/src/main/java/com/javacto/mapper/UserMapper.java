package com.javacto.mapper;

import com.javacto.po.Role;
import com.javacto.po.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
@SuppressWarnings("all")
public interface UserMapper {
    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM users")

    public List<UserInfo> queryAll();
    /**
     * 添加用户信息
     */
    @Insert("insert into users(id,email,username,password,phoneNum,status) values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    public  void insert(UserInfo info);

    /**
     * 根据id查询用户信息
     */
    @Select("select * from users where id=#{userId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id",
                    many = @Many(select = "com.javacto.mapper.RoleMapper.findRoleByUserId",fetchType = FetchType.EAGER))
    })
    public UserInfo findById(String userId);


    //查询可以添加的用户权限
    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    public List<Role> findOtherRoles(String userId);
    //添加权限，必需使用注解
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);



    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id",
                    many = @Many(select = "com.javacto.mapper.RoleMapper.findRoleByUserId",fetchType = FetchType.EAGER))
    })
    public UserInfo findByName(String username);

}
