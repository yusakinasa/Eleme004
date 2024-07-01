package org.example.eleme.controller;


import org.example.eleme.service.CartService;
import org.example.eleme.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/delivery_address")
public class DeliveryAddressController {
//    private CartMapper cartMapper;

    @Autowired
    private DeliveryAddressService deliveryAddressService;



    @RequestMapping("/all")
    public Map<String,Object> getAll(){
//        cartService.

        Map mapjson = new HashMap<>();
        mapjson.put("data",deliveryAddressService.getAllDeliveryAddresses());
        System.out.println(mapjson);
        return mapjson;
    }
}
