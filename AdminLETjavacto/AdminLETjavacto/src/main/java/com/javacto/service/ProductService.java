package com.javacto.service;

import com.javacto.po.Product;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
public interface ProductService {
    /**
     * 添加
     * @param product
     */
    public  void  save(Product product);
    /**
     * 删除
     */
    public  void delete(String id);

    /**
     * 根据id查询
     */
    public Product findById(String id);

    /**
     * 改
     */
    public  void update(Product product);
    /**
     * 查
     */
    public List<Product> findAll();
}
