package cn.itnanls;

import cn.itnanls.entity.BeanUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class BeforeInit implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       if (bean instanceof BeanUser){
           System.out.println("初始化前--------");
          BeanUser beanUser =(BeanUser) bean;
           System.out.println(beanUser);
          beanUser.setUsername("张三");
           System.out.println(beanUser);
          return  beanUser;
       }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanUser){
            System.out.println("初始化后--------");
            BeanUser beanUser =(BeanUser) bean;
            System.out.println(beanUser);
            beanUser.setPassword("123456");
            System.out.println(beanUser);
            return  beanUser;
        }
        return bean;
    }
}
