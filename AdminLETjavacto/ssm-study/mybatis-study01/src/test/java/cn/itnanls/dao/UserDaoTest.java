package cn.itnanls.dao;

import cn.itnanls.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class UserDaoTest {
    UserDao userDao=null;
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
        userDao = session.getMapper(UserDao.class);
    }
    @Test
    public void selectUserByIdTest(){
        //执行方法
        User user=userDao.selectUserById(1);
        System.out.println(user);
    }
    @Test
   public void saveUserTest(){
        //执行方法
        int rows = userDao.saveUser(new User(4, "c", "v"));
        System.out.println(rows);

   }
    @Test
    public void deleteUserByIdTest(){
        //执行方法
        int rows = userDao.deleteUserById(4);
        System.out.println(rows);
        //所有的更新语句（增加、删除、修改）都需要提交，以后不需要写，因为是测试方法

    }

    @Test
    public void updateUserTest(){
        //执行方法
        int rows = userDao.updateUser(new User(4, null, "D"));
        System.out.println(rows);
    }

    @Test
    public void updateUserTest2(){
        //执行方法
        int rows = userDao.updateUser2(new User(4, "a", null));
        System.out.println(rows);
    }
    @Test
    public void updateUserTest3(){
        //执行方法
        int rows = userDao.updateUser3(new User(4, "a", null));
        System.out.println(rows);
    }
    @Test
    public void findAllUsersTest(){
        //执行方法

        List<User> allUsers = userDao.findAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUsersTest(){
        //执行方法
        //查询条件
        User user =new User(null,"B","D");
        List<User> allUsers = userDao.queryUsers(user);
        for (User user1 : allUsers) {
            System.out.println(user1);
        }
    }

    @Test
    public void queryUsersTest2(){
        //执行方法
        //查询条件
        User user =new User(null,"B","D");
        List<User> allUsers = userDao.queryUsers2(user);
        for (User user1 : allUsers) {
            System.out.println(user1);
        }
    }
    @Test
    public void queryUsersTest3(){
        //执行方法
        //查询条件
        User user =new User(null,"B","dsad");
        List<User> allUsers = userDao.queryUsers3(user);
        for (User user1 : allUsers) {
            System.out.println(user1);
        }
    }

    @Test
    public void queryUsersByIdsTest(){
        //执行方法
        //查询条件
        List<Integer> ids = Arrays.asList(1, 2, 3);
        List<User> allUsers = userDao.queryUsersByIds(ids);
        for (User user1 : allUsers) {
            System.out.println(user1);
        }
    }

    @Test
    public void findUserByNameTest(){
        //执行方法
        List<User> users = userDao.findUsersByName("a");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserByNameTest2(){
        //执行方法
        List<User> users = userDao.findUsersByName2("a");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void addUser2(){
        User user2=new User();
        user2.setUsername("B");
        //执行方法
        int insert = session.insert("cn.itnanls.dao.UserDao.add2", user2);
        System.out.println(user2.getId());
    }

    @After
     public void  after(){
        session.commit();
        //如果遇到问题要回滚
        //session.rollback();
     }

}
