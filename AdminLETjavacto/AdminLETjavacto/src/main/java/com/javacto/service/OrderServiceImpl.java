package com.javacto.service;

import com.javacto.mapper.OrderMapper;
import com.javacto.po.Orders;
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
public class OrderServiceImpl implements  OrderService{

    @Autowired
    private OrderMapper orderMapper;
    public List<Orders> findAll(){
        return orderMapper.findAll();
    }

    public Orders findById(String ordersId){
       return orderMapper.findById(ordersId);
    }
}
