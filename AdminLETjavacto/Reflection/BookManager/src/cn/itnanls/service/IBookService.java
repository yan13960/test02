package cn.itnanls.service;

import cn.itnanls.entity.Book;
import cn.itnanls.entity.User;

/**
 *
 */
public interface IBookService {
    /**
     * 这是借书方法
     * @param user
     * @param book
     */
    void  borrow(User user, Book book);
}
