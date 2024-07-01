package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.Food;

import java.util.List;

@Mapper
public interface FoodMapper extends BaseMapper<Food> {
    @Select("select * from food")
    List<Food> getAll();
}
