package com.javacto.contoller;

import com.javacto.po.Orders;
import com.javacto.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
@Controller
@RequestMapping("/order")
public class OrderAction {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/queryAll")
    @Secured("ROLE_USER")
    public  String  findAll(Model model){
        List<Orders> list = orderService.findAll();
        model.addAttribute("ordersList",list);
        return "orders-list";
    }

    @RequestMapping("/findById")
    public  String  findById(Model model, String id){
        Orders orders = orderService.findById(id);
        model.addAttribute("orders",orders);
        return "orders-show";
    }
}
