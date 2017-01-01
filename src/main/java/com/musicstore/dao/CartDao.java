package com.musicstore.dao;

import com.musicstore.model.Cart;

public interface CartDao {

    Cart getCartById(int cartId);

    void updateCart(Cart cart);
}
