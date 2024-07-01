package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



@TableName("business")
@Data
public class Business {

    @TableId(type = IdType.AUTO)
    private Long business_id;
    private String name;
    private String image_url;
    private Float rating;
    private Integer sales_volume;
    private Float distance;
    private Float avg_price;
    private String address;
    private String notice;
    private String phone;



    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
