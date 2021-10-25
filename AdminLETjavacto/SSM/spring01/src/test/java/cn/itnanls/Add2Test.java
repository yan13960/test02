package cn.itnanls;


import cn.itnanls.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class Add2Test {
    @Test
    public void iocTest() {

        //1.创建容器
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ApplicationAdd2.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
    }
}
