package org.example.eleme.controller;


import org.example.eleme.service.CartItemService;
import org.example.eleme.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cart_item")
public class CartItemController {
//    private CartMapper cartMapper;

    @Autowired
    private CartItemService cartItemService;



    @RequestMapping("/all")
    public Map<String,Object> getAll(){

        Map mapjson = new HashMap<>();
        mapjson.put("data",cartItemService.getAllCartItems());
        System.out.println(mapjson);
        return mapjson;
    }
}
