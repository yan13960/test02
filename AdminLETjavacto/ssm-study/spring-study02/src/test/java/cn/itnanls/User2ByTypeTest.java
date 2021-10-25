package cn.itnanls;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class User2ByTypeTest {
    @Test
    public void iocTest(){
        //1.根据配置文件构建一个应用上下文
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("application2ByType.xml");
        User2 user2 = (User2) applicationContext.getBean(User2.class);
        System.out.println(user2);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(User2.class);
        System.out.println(beanNamesForType[0]);//不加名字 全路径名称
    }
}
