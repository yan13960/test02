package com.javacto.service;

import com.javacto.mapper.ProductMapper;
import com.javacto.po.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    /**
     * 添加
     * @param product
     */
    public  void  save(Product product){
        productMapper.save(product);
    }
    /**
     * 删除
     */
    public  void delete(String id){
        productMapper.delete(id);
    }
    /**
     * 根据id查询
     */
    public Product findById(String id){
       return productMapper.findById(id);
    }

    /**
     * 改
     */
    public  void update(Product product){
        productMapper.update(product);
    }
    /**
     * 查
     */
    public List<Product> findAll(){
       return  productMapper.findAll();
    }
}
