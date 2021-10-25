package cn.itnanls;

import cn.itnanls.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class User2Test {
    @Test
    public void iocTest() {

        //1.创建容器
       ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("Application.xml");
        UserController userController = applicationContext.getBean(UserController.class);
        userController.showUser(1);
    }
}
