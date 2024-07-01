package org.example.eleme.controller;


import org.example.eleme.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
//    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;



    @RequestMapping("/all")
    public Map<String,Object> getAll(){
//        orderService.

        Map mapjson = new HashMap<>();
        mapjson.put("data",orderService.getAllOrders());
        System.out.println(mapjson);
        return mapjson;
    }
}
