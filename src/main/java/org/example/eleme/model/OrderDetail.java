package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;


@TableName("order_detail")
@Data
public class OrderDetail {

    @TableId(type = IdType.AUTO)
    private Long order_detail_id;
    private Long order_id;
    private Long food_id;
    private Integer quantity;
    private BigDecimal total_price;

    private Order order;   // 关联的 Orders 对象
    private Food food;      // 关联的 Food 对象


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
