package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.Cart;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    @Select("select * from cart")
    List<Cart> getAll();
}
