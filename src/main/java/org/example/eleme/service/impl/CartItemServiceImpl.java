package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.CartItemMapper;
import org.example.eleme.model.CartItem;
import org.example.eleme.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartItemService")
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper,CartItem>  implements CartItemService {



    public List<CartItem> getAllCartItems() {
        return baseMapper.getAll();
    }

//    public CartItem getCartItemById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public CartItem createCartItem(CartItem user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteCartItem(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public CartItem getCartItemByCartItemname(String username) {
//        return userRepository.findByCartItemname(username);
//    }
}
