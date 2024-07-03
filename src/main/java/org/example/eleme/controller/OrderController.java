package org.example.eleme.controller;


import org.example.eleme.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.example.eleme.model.Order;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
//    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/")
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @PutMapping("/{orderId}")
    public void updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        orderService.updateOrder(order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }



    @RequestMapping("/all")
    public Map<String,Object> getAll(){
//        orderService.

        Map mapjson = new HashMap<>();
        mapjson.put("data",orderService.getAllOrders());
        System.out.println(mapjson);
        return mapjson;
    }
}
