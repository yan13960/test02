package cn.itnanls;

import cn.itnanls.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:BeanApplication.xml")*/
public class AopUserTest {




     @Test
     public void iocTest() {

         //1.创建容器
         ApplicationContext applicationContext =
                 new ClassPathXmlApplicationContext("AopApplication.xml");
         IUserService iUserService = applicationContext.getBean(IUserService.class);
         iUserService.findUserById(1);
     }
}
