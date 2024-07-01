package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.FoodMapper;
import org.example.eleme.model.Food;
import org.example.eleme.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("foodService")
public class FoodServiceImpl extends ServiceImpl<FoodMapper,Food>  implements FoodService {



    public List<Food> getAllFoods() {
        return baseMapper.getAll();
    }

//    public Food getFoodById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public Food createFood(Food user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteFood(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public Food getFoodByFoodname(String username) {
//        return userRepository.findByFoodname(username);
//    }
}
