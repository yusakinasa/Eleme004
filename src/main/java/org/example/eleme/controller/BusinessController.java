package org.example.eleme.controller;


import org.example.eleme.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/business")
public class BusinessController {
//    private BusinessMapper businessMapper;

    @Autowired
    private BusinessService businessService;



    @RequestMapping("/all")
    public Map<String,Object> getAll(){
//        businessService.

        Map mapjson = new HashMap<>();
        mapjson.put("data",businessService.getAllBusinesses());
        System.out.println(mapjson);
        return mapjson;
    }
}
