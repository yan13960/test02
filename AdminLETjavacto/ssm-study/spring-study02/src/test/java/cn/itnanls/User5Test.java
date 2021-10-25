package cn.itnanls;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class User5Test {

    @Test
    public void iocTest(){
        //1.根据配置文件构建一个应用上下文
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("application5.xml");

        User5 user5 = applicationContext.getBean(User5.class);
        System.out.println(user5);
    }
}
