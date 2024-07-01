package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.UserMapper;
import org.example.eleme.model.User;
import org.example.eleme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper,User>  implements UserService {



    public List<User> getAllUsers() {
        return baseMapper.getAll();
    }

//    public User getUserById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public User getUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
}
