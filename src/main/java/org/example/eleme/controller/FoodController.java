package org.example.eleme.controller;


import org.example.eleme.service.CartService;
import org.example.eleme.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodController {
//    private CartMapper cartMapper;

    @Autowired
    private FoodService foodService;



    @RequestMapping("/all")
    public Map<String,Object> getAll(){
//        cartService.

        Map mapjson = new HashMap<>();
        mapjson.put("data",foodService.getAllFoods());
        System.out.println(mapjson);
        return mapjson;
    }
}
