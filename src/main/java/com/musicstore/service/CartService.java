package com.musicstore.service;

import java.io.IOException;

import com.musicstore.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);
    
    void updateCart(Cart cart);
    
    Cart validate(int cartId) throws IOException;
}
