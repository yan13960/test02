package cn.itnanls;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class UserTest {
    @Test
    public void iocTest(){
        //1.根据配置文件构建一个应用上下文
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("application.xml");
        User user = (User) applicationContext.getBean("user");

        user.say();
        System.out.println(user);
    }
}
