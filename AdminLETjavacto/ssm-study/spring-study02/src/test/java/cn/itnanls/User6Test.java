package cn.itnanls;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class User6Test {

    @Test
    public void iocTest(){
        //1.根据配置文件构建一个应用上下文
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("application6.xml");

        User6 user6 = applicationContext.getBean(User6.class);
        System.out.println(user6);
    }
}
