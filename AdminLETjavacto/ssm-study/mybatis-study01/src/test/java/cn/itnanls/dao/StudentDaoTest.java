package cn.itnanls.dao;

import cn.itnanls.entity.Student;
import cn.itnanls.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 *
 */
public class StudentDaoTest {
    StudentDao studentDao=null;
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
        studentDao = session.getMapper(StudentDao.class);
    }
    @Test
    public void selectUserByIdTest(){
        //执行方法
        Student student=studentDao.selectStudentById(1);
        System.out.println(student);
    }
    @Test
   public void saveUserTest(){
        //执行方法
        int rows = studentDao.saveStudent(new Student(7, "c", "v"));
        System.out.println(rows);

   }
    @Test
    public void deleteUserByIdTest(){
        //执行方法
        int rows = studentDao.deleteStudentById(4);
        System.out.println(rows);
        //所有的更新语句（增加、删除、修改）都需要提交，以后不需要写，因为是测试方法

    }

    @Test
    public void updateUserTest(){
        //执行方法
        int rows = studentDao.updateStudent(new Student(7, "B", "D"));
        System.out.println(rows);
    }

    @After
     public void  after(){
        session.commit();
        //如果遇到问题要回滚
        //session.rollback();
        session.close();
     }
}
