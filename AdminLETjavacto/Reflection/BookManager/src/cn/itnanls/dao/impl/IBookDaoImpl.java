package cn.itnanls.dao.impl;

import cn.itnanls.Annotation.Bean;
import cn.itnanls.dao.IBookDao;
import cn.itnanls.entity.Book;

import java.util.List;

/**
 *
 */
@Bean
public class IBookDaoImpl implements IBookDao {

    @Override
    public Book findBookById(int id) {
        System.out.println("这里是bookDao—findBookById");
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        System.out.println("这里是bookDao—findAllBooks");
        return null;
    }

    @Override
    public void saveBook(Book book) {
        System.out.println("这里是bookDao—saveBook");
    }
}
