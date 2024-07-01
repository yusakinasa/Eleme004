package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.Category;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    @Select("select * from category")
    List<Category> getAll();
}
