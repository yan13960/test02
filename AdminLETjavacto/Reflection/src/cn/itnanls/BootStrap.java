package cn.itnanls;

import cn.itnanls.dao.IBookDao;
import cn.itnanls.dao.IUserDao;
import cn.itnanls.dao.impl.IBookDaoImpl;
import cn.itnanls.dao.impl.UserDaoImpl;
import cn.itnanls.entity.Book;
import cn.itnanls.entity.User;
import cn.itnanls.reflect.ApplicationContext;
import cn.itnanls.service.IBookService;
import cn.itnanls.service.IUserService;

/**
 *
 */
public class BootStrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ApplicationContext();

        //applicationContext.initContext();
        applicationContext.initContextByAnnotation();
        IBookService bean =(IBookService) applicationContext.getBean(IBookService.class);
        //System.out.println(bean);
        bean.borrow(new User("aaa","sd","123",12),new Book());
    }
}
