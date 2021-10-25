package cn.itnanls;

import cn.itnanls.entity.Book;
import cn.itnanls.entity.User;
import cn.itnanls.reflect.ApplicationContext;
import cn.itnanls.service.IBookService;
import cn.itnanls.service.IDogService;

/**
 *
 */
public class BootStrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ApplicationContext();

        //applicationContext.initContext();
        applicationContext.initContextByAnnotation();
        IDogService bean =(IDogService) applicationContext.getBean(IDogService.class);
        //System.out.println(bean);
        bean.findKiller(12);
    }
}
