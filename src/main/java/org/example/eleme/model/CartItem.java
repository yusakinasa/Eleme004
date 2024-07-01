package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;


@TableName("cart_item")
@Data
public class CartItem {

    @TableId(type = IdType.AUTO)
    private Long cart_item_id;
    private Long cart_id;
    private Long food_id;
    private Integer quantity;
    private BigDecimal total_price;

    private Cart cart;   // 关联的 Cart 对象
    private Food food;   // 关联的 Food 对象


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
