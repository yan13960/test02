package cn.itnanls;


import cn.itnanls.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Driver;

/**
 *
 */
public class DriverTest {
    @Test
    public void iocTest() {

        //1.创建容器
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ApplicationAdd2.xml");
        Driver bean = applicationContext.getBean(Driver.class);
        System.out.println(bean);
    }

    @Test
    public void iocTest2() {

        //1.创建容器
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ApplicationAdd2.xml");
       // Driver bean = applicationContext.getBean(User.class);
        User bean = (User) applicationContext.getBean("nan");
        System.out.println(bean);
    }
}
