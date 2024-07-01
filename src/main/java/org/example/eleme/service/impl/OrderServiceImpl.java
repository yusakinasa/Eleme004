package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.OrderMapper;
import org.example.eleme.model.Order;
import org.example.eleme.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order>  implements OrderService {



    public List<Order> getAllOrders() {
        return baseMapper.getAll();
    }

//    public Order getOrderById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public Order createOrder(Order user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteOrder(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public Order getOrderByOrdername(String username) {
//        return userRepository.findByOrdername(username);
//    }
}
