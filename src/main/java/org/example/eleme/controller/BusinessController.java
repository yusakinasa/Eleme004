package org.example.eleme.controller;

import org.example.eleme.model.Business;
import org.example.eleme.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/all")
    public Map<String, Object> getAll() {
        Map<String, Object> mapjson = new HashMap<>();
        mapjson.put("data", businessService.getAllBusinesses());
        return mapjson;
    }
}

