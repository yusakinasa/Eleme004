package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;


@TableName("food")
@Data
public class Food {

    @TableId(type = IdType.AUTO)
    private Long food_id;
    private Long category_id;
    private String name;
    private String image_url;
    private BigDecimal price;

    private Category category; // 关联的 Category 对象


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
