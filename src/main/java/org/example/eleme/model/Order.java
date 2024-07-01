package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@TableName("order")
@Data
public class Order {

    @TableId(type = IdType.AUTO)
    private Long order_id;
    private Long user_id;
    private Long business_id;
    private BigDecimal total_price;
    private LocalDateTime delivery_time;
    private String payment_method;
    private LocalDateTime order_time;

    private User user;         // 关联的 User 对象
    private Business business; // 关联的 Business 对象


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
