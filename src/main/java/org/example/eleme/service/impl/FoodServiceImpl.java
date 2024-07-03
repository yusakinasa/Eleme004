package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.FoodMapper;
import org.example.eleme.model.Food;
import org.example.eleme.service.FoodService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service("foodService")
public class FoodServiceImpl extends ServiceImpl<FoodMapper,Food>  implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    public List<Food> getAllFoods() {
        return baseMapper.getAll();
    }


    public Food findById(Long foodId) {
        return baseMapper.findById(foodId);
    }

    public List<Food> findByCategoryId(Long categoryId) {
        return foodMapper.findByCategoryId(categoryId);
    }
    public void saveFood(Food food) {
       foodMapper.saveFood(food);
    }
    public void updateFood(Food food) {
        baseMapper.updateFood(food);
    }
    public void deleteFood(Long foodId) {
        baseMapper.deleteFood(foodId);
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
