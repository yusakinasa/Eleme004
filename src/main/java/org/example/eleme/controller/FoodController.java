package org.example.eleme.controller;


import org.example.eleme.service.CartService;
import org.example.eleme.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.example.eleme.model.Food; // 根据实际的包路径调整
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodController {
//    private CartMapper cartMapper;

    @Autowired
    private FoodService foodService;

    @GetMapping("/{foodId}")
    public Food getFoodById(@PathVariable Long foodId) {
        return foodService.findById(foodId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Food> getFoodsByCategoryId(@PathVariable Long categoryId) {
        return foodService.findByCategoryId(categoryId);
    }

    @PostMapping("/save")
    public void saveFood(@RequestBody Food food) {
        foodService.saveFood(food);
    }

    @PutMapping("/update")
    public void updateFood(@RequestBody Food food) {
        foodService.updateFood(food);
    }

    @DeleteMapping("/delete/{foodId}")
    public void deleteFood(@PathVariable Long foodId) {
        foodService.deleteFood(foodId);
    }

    @RequestMapping("/all")
    public Map<String,Object> getAll(){
//        cartService.

        Map mapjson = new HashMap<>();
        mapjson.put("data",foodService.getAllFoods());
        System.out.println(mapjson);
        return mapjson;
    }
}
