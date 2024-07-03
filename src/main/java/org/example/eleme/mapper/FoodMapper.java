package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.Food;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface FoodMapper extends BaseMapper<Food> {
    Food findById(@Param("foodId") Long foodId);
    List<Food> findByCategoryId(Long categoryId);
    @Select("select * from food")
    List<Food> getAll();
    void save(Food food);
    void saveFood(Food food);
    void updateFood(Food food);

    void update(Food food);

    void deleteFood(Long foodId);

    void deleteById(@Param("foodId") Long foodId);
}
