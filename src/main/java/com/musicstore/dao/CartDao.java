package com.musicstore.dao;
import com.musicstore.model.Cart;
import com.musicstore.model.Product;

public interface CartDao {

    public Cart createCart(Cart cart);
    public void deleteCart(Cart cart);
    public Cart retrieveCart(String cartId);
    public void updateCart(Cart cart, String cartId);
}
