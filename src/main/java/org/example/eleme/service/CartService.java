package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.Cart;

import java.util.List;


public interface CartService extends IService<Cart> {


    public List<Cart> getAllCarts() ;

//    public Cart getCartById(Long id);
//
//    public Cart createCart(Cart user);
//
//    public void deleteCart(Long id);
//
//    public Cart getCartByCartname(String username);
}
