package cn.itnanls;

import cn.itnanls.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 *
 */
public class UserControllerTest {

    @Test
    public void iocTest(){
        //1.根据配置文件构建一个应用上下文
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("application6.xml");

      /* UserController userController = applicationContext.getBean(UserController.class);
       userController.showUser(1);*/

        /*DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource);*/

        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource2");
        System.out.println(dataSource);

    }
}
