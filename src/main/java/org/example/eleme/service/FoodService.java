package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.Food;

import java.util.List;


public interface FoodService extends IService<Food> {


    public List<Food> getAllFoods() ;
    Food findById(Long foodId);
    List<Food> findByCategoryId(Long categoryId);
    void saveFood(Food food);
    void updateFood(Food food);
    void deleteFood(Long foodId);

//    public Food getFoodById(Long id);
//
//    public Food createFood(Food user);
//
//    public void deleteFood(Long id);
//
//    public Food getFoodByFoodname(String username);
}
