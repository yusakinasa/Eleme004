package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.CartItem;

import java.util.List;

@Mapper
public interface CartItemMapper extends BaseMapper<CartItem> {
    @Select("select * from cart_item")
    List<CartItem> getAll();
}
