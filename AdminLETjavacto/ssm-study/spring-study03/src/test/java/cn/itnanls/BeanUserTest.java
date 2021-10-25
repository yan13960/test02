package cn.itnanls;

import cn.itnanls.entity.BeanUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:BeanApplication.xml")*/
public class BeanUserTest {




     @Test
     public void iocTest() {

         //1.创建容器
         ApplicationContext applicationContext=
                 new ClassPathXmlApplicationContext("BeanApplication.xml");
         //2.获得bean对象--------构造--------
         //--------注入--------
         //--------init初始化--------
         //--------使用了--------
         //BeanUser{id=12, username='null', password='null'}
         BeanUser bean = applicationContext.getBean(BeanUser.class);
         System.out.println(bean);
         //3.销毁容器
         ((AbstractApplicationContext)applicationContext).registerShutdownHook();

     }

    @Test
    public void lazyIocTest() {

        //1.创建容器
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("BeanApplication.xml");

    }
}
