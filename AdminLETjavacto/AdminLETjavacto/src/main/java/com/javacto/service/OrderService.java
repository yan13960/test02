package com.javacto.service;

import com.javacto.po.Orders;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
public interface OrderService {
    public List<Orders> findAll();

    public Orders findById(String ordersId);
}
