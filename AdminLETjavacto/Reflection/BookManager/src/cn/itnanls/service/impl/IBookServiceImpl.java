package cn.itnanls.service.impl;

import cn.itnanls.Annotation.AutoWird;
import cn.itnanls.Annotation.Bean;
import cn.itnanls.dao.IBookDao;
import cn.itnanls.dao.IUserDao;
import cn.itnanls.entity.Book;
import cn.itnanls.entity.User;
import cn.itnanls.service.IBookService;
import org.junit.Test;

import java.util.List;

/**
 *
 */
@Bean
public class IBookServiceImpl implements IBookService {
    @AutoWird
    private IUserDao userDao ;
    @AutoWird
    private IBookDao bookDao ;
    @Override
    @Test
    public void borrow(User user, Book book) {
        List<User> allUsers = userDao.findAllUsers();
        System.out.println(user.getUsername()+"借了"+book.getName());
    }

}
