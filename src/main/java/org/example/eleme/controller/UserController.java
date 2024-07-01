package org.example.eleme.controller;


import org.example.eleme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
//    private UserMapper userMapper;

    @Autowired
    private UserService userService;



    @RequestMapping("/all")
    public Map<String,Object> getAll(){
//        userService.

        Map mapjson = new HashMap<>();
         mapjson.put("data",userService.getAllUsers());
        System.out.println(mapjson);
        return mapjson;
    }
}
