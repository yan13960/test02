package cn.itnanls.dao;

import cn.itnanls.entity.Employee;
import cn.itnanls.entity.Student;
import cn.itnanls.entity.User;
import cn.itnanls.mapper.EmployeeMapper;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class EmployeeMapperTest {
    EmployeeMapper employeeMapper=null;
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
        employeeMapper = session.getMapper(EmployeeMapper.class);
    }

   @Test
   public void findEmployeeByIdTest(){
       //执行方法
       Employee employee = employeeMapper.findEmployeeById(1);
       System.out.println(employee);
   }

    @Test
    public void findAllEmployeeTest(){
        //执行方法
        List<Employee> allEmployees = employeeMapper.findAllEmployees();
        for (Employee allEmployee : allEmployees) {
            System.out.println(allEmployee);
        }
    }

    @Test
    public void findEmployeeById2Test(){

        //执行方法
        Employee employee = employeeMapper.findEmployeeById2(1);
        System.out.println(employee);
    }

    @Test
    public void findEmployeeByIdLazyTest(){
        Map<String,Object> cache =new HashMap<>(8);
        //执行方法
        Employee employee = employeeMapper.findEmployeeById2(1);

    }

    @After
     public void  after(){
        session.commit();
        //如果遇到问题要回滚
        //session.rollback();
        session.close();
     }
}
