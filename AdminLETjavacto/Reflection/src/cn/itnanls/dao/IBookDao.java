package cn.itnanls.dao;

import cn.itnanls.entity.Book;
import cn.itnanls.entity.User;

import java.util.List;

/**
 *
 */
public interface IBookDao {
    /**
     * 根据id找到一个book
     * @param id
     * @return
     */

    Book findBookById(int id);

    /**
     * 获取所有的book
     * @return
     */
    List<Book> findAllBooks();

    /**
     * 保存book
     * @param book
     */
    void  saveBook(Book book);
}
