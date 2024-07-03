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
    private Long orderid;
    private Long userid;
    private Long businessid;
    private BigDecimal totalprice;
    private LocalDateTime deliverytime;
    private String payment_method;
    private Long addressid;

    private User user;         // 关联的 User 对象
    private Business business; // 关联的 Business 对象
    private DeliveryAddress deliveryAddress; // 关联的 DeliveryAddress 对象


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
