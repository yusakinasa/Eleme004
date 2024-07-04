package org.example.eleme.controller;

import org.example.eleme.model.Order;
import org.example.eleme.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping("/orders/{userid}")
    public List<Order> getOrdersByUserId(@PathVariable Long userid) {
        return orderService.getOrdersByUserId(userid);
    }

    @DeleteMapping("/order/{orderid}")
    public void deleteOrder(@PathVariable Long orderid) {
        orderService.deleteOrder(orderid);
    }
}

