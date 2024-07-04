package org.example.eleme.service;

import org.example.eleme.model.Order;
import java.util.List;

public interface OrderService {
    void createOrder(Order order);
    List<Order> getOrdersByUserId(Long userid);
    void deleteOrder(Long orderid);  // 添加删除订单的方法
}
