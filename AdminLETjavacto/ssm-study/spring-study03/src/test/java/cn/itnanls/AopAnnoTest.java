package cn.itnanls;

import cn.itnanls.controller.UserController;
import cn.itnanls.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class AopAnnoTest {
    @Test
    public void iocTest() {

        //1.创建容器
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("AopApplication2.xml");
        UserController userController = applicationContext.getBean(UserController.class);
        String s = userController.showUser(1);
        System.out.println(s);
    }
}
