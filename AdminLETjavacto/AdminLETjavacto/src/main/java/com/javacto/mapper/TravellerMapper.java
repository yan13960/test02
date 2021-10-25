package com.javacto.mapper;

import com.javacto.po.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * describe  旅客
 * 作者：曾昭武
 */
public interface TravellerMapper {

    @Select("SELECT * FROM traveller WHERE id IN(SELECT travellerId FROM order_traveller WHERE orderId=#{ordersId}) ")
    public List<Traveller> findByOrdersId(String ordersId);
}
