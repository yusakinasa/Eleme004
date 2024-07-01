package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.Order;

import java.util.List;


public interface OrderService extends IService<Order> {


    public List<Order> getAllOrders() ;

//    public Order getOrderById(Long id);
//
//    public Order createOrder(Order user);
//
//    public void deleteOrder(Long id);
//
//    public Order getOrderByOrdername(String username);
}
