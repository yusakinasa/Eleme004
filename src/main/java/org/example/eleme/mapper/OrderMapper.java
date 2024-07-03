package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.Order;
import org.apache.ibatis.annotations.Param;
import java.util.List;


import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from order")
    List<Order> getAll();
    Order findOrderById(@Param("orderId") Long orderId);

    void insertOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(@Param("orderId") Long orderId);
}
