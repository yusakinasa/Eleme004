package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.CartItem;

import java.util.List;


public interface CartItemService extends IService<CartItem> {


    public List<CartItem> getAllCartItems() ;

//    public CartItem getCartItemById(Long id);
//
//    public CartItem createCartItem(CartItem user);
//
//    public void deleteCartItem(Long id);
//
//    public CartItem getCartItemByCartItemname(String username);
}
