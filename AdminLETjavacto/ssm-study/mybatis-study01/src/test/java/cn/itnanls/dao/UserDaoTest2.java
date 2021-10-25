package cn.itnanls.dao;

import cn.itnanls.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class UserDaoTest2 {
    UserDao2 userDao2=null;
    SqlSession session=null;
    @Before
    public void before(){
        //构建一个session工厂
        InputStream resource = User.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);
        //获取session
        session=sqlSessionFactory.openSession();
        //回去代理对象
        userDao2 = session.getMapper(UserDao2.class);
    }
    @Test
    public void selectUserByIdTest(){
        //执行方法
        User user=userDao2.selectUserById(1);
        System.out.println(user);
    }


    @Test
    public void selectUserByIdTest2(){
        User user=new User(4,"a","b");
        //执行方法
        user = userDao2.selectUserById2(user);
        System.out.println(user);
    }

    //日志打印
    Logger logger=LoggerFactory.getLogger(this.getClass());
    @Test
    public void selectUserByIdTest3(){
        //执行方法
        User  user = userDao2.selectUserById3(4,"a");
        System.out.println(user);
        logger.debug("这是日志打印的内容");
    }

    @Test
    public void selectUserByIdTest4(){
        //执行方法
        User  user = userDao2.selectUserById4(4,"a");
        System.out.println(user);
        logger.debug("这是日志打印的内容");
    }

    @After
     public void  after(){
        session.commit();
        //如果遇到问题要回滚
        //session.rollback();
     }

}
