package org.example.eleme.controller;


import org.example.eleme.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
//    private CartMapper cartMapper;

    @Autowired
    private CartService cartService;



    @RequestMapping("/all")
    public Map<String,Object> getAll(){
//        cartService.

        Map mapjson = new HashMap<>();
        mapjson.put("data",cartService.getAllCarts());
        System.out.println(mapjson);
        return mapjson;
    }
}
