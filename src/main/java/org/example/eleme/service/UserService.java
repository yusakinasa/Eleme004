package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.User;
import java.util.List;


public interface  UserService extends IService<User> {


    public List<User> getAllUsers() ;

//    public User getUserById(Long id);
//
//    public User createUser(User user);
//
//    public void deleteUser(Long id);
//
//    public User getUserByUsername(String username);
}
