package com.musicstore.dao;
import com.musicstore.model.Cart;

public interface CartDao {

    public Cart createCart(Cart cart);
    public void deleteCart(String cartId);
    public Cart retrieveCart(String cartId);
    public void updateCart(Cart cart, String cartId);
}
