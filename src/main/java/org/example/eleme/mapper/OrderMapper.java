package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.eleme.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @Select("SELECT * FROM orders WHERE userid = #{userid}")
    List<Order> getOrdersByUserId(Long userid);
}
