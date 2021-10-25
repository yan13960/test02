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
public interface UserDao2 {
    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User selectUserById(int id);

    User selectUserById2(User user);

    User selectUserById3(@Param("ids") Integer id, @Param("username") String username);

    User selectUserById4(@Param("id") Integer id, @Param("username") String username);
}
