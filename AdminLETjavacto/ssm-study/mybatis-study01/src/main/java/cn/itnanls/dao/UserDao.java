package cn.itnanls.dao;

import cn.itnanls.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 根据ID查询用户表信息
 * 1.创建工程
 * 2.导入mybatis的jar包
 * 3.数据库初始化
 * 4.创建对应的实体类
 * 5.创建SqlMapConfig.xml配置文件并配置
 * 6.创建UserMapping.xml 在这里写sql语句
 * 7.把UserMapper.xml配置到SqlMapConfig.xml文件当中
 * 8.测试
 */
public interface UserDao {
    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User selectUserById(int id);
    /**
     * 删除一个用户
     * @param id
     * @return
     */
    int deleteUserById(int id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 动态sql
     * @param user
     * @return
     */
    int updateUser2(User user);

    int updateUser3(User user);
    /**
     * 新增用户
     * @param
     * @param user
     * @param
     * @return
     */
    int saveUser(User user);

    /**
     * 返回所有的用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 根据id查找用户  多条件查询
     * @param user
     * @return
     */
    List<User> queryUsers(User user);

    List<User> queryUsers2(User user);

    List<User> queryUsers3(User user);

    List<User> queryUsersByIds( List<Integer> list);
    //List<User> queryUsersByIds(@Param("ids") List<Integer> ids);

    /**
     * 查询名字相关的用户
     * @param name
     * @return
     */
    List<User> findUsersByName(String name);

    /**
     * 查询名字相关的用户  模糊查询
     * @param name
     * @return
     */
    List<User> findUsersByName2(String name);
}
