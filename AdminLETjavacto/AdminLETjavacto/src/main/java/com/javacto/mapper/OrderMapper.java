package com.javacto.mapper;

import com.javacto.po.Member;
import com.javacto.po.Orders;
import com.javacto.po.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
public interface OrderMapper {
    /**
     * 查询订单，关联查询出产品信息
     */
    @Select("SELECT * FROM orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),

            @Result(property = "product",column = "productId",javaType = Product.class,
            one = @One(select = "com.javacto.mapper.ProductMapper.findById"))
    })
    public List<Orders> findAll();

    @Select("SELECT * FROM orders where id=#{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),

            @Result(property = "product",column = "productId",javaType = Product.class,
                    one = @One(select = "com.javacto.mapper.ProductMapper.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,
                    one = @One(select = "com.javacto.mapper.MemberMapper.findById")),
            @Result(property = "travellers",column = "id"
            ,many = @Many(select = "com.javacto.mapper.TravellerMapper.findByOrdersId",fetchType = FetchType.LAZY))
    })
    public Orders findById(String ordersId);
}
