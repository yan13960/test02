package cn.itnanls;

import cn.itnanls.core.Session;
import cn.itnanls.core.SessionFactory;
import cn.itnanls.dao.StudentDao;
import cn.itnanls.dao.UserDao;
import cn.itnanls.entity.User;

import java.util.List;

/**
 *
 */
public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new SessionFactory("mybatis-config.xml");
        Session session = sessionFactory.openSession();
        System.out.println(session.getConnection());
        //生成代理对象
        UserDao userDao=session.getMapper(UserDao.class);
        //userDao.saveUser(new User(5,"a","b"));
        List<User> user = userDao.findUser(5);
        System.out.println(user);

        StudentDao studentDao=session.getMapper(StudentDao.class);
        List<User> student = studentDao.findStudent(1);
        System.out.println(student);
    }
}
