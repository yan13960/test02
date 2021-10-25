package com.javacto.mapper;

import com.javacto.po.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *
 */
public interface ProductMapper {

    /**
     * 增
     */
    @Insert("INSERT INTO PRODUCT (id, productnum, productname, cityname, departuretime, productprice,productdesc, productstatus) VALUES " + "(#{id}, #{productNum}, #{productName}, #{cityName}," +
            " #{departureTime},#{productPrice},#{productDesc},#{productStatus});")
    public  void  save(Product product);
    /**
     * 删除
     */
    @Delete("delete from product where id=#{id}")
    public  void delete(String id);

    /**
     * 根据id查询
     */
    @Select("select * from product where id=#{id}")
    public Product findById(String id);

    /**
     * 改
     */
    @Update("update product set  productNum =#{productNum}  where id=#{id} ")
    public  void update(Product product);
    /**
     * 查
     */
    @Select("select * from product")
    public List<Product> findAll();

}
