package cn.itnanls;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class User3Test {

    @Test
    public void iocTest(){
        //1.根据配置文件构建一个应用上下文
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("application3.xml");

        User3 user3 = applicationContext.getBean(User3.class);
        System.out.println(user3);
        User3 otherUser = applicationContext.getBean(User3.class);
        System.out.println(otherUser);
        System.out.println(user3 == otherUser);
    }
}
