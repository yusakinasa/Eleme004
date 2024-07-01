package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.CartMapper;
import org.example.eleme.model.Cart;
import org.example.eleme.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartMapper,Cart>  implements CartService {



    public List<Cart> getAllCarts() {
        return baseMapper.getAll();
    }

//    public Cart getCartById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public Cart createCart(Cart user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteCart(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public Cart getCartByCartname(String username) {
//        return userRepository.findByCartname(username);
//    }
}
