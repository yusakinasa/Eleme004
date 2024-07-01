package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.User;


import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> getAll();
}
