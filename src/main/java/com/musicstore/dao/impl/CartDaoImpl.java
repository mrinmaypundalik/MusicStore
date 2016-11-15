package com.musicstore.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.musicstore.dao.CartDao;
import com.musicstore.model.Cart;

public class CartDaoImpl implements CartDao {

    private Map<String, Cart> listOfCarts;

    public CartDaoImpl() {
	this.listOfCarts = new HashMap<String, Cart>();
    }

    public Cart createCart(Cart cart) {
	if (listOfCarts.containsKey(cart.getCartId())) {
	    throw new IllegalArgumentException(String.format("Cart with ID-% already exists", cart.getCartId()));
	}
	listOfCarts.put(cart.getCartId(), cart);
	return cart;
    }

    public void deleteCart(Cart cart) {
	if (!listOfCarts.containsKey(cart.getCartId())) {
	    throw new IllegalArgumentException(String.format("Cart with ID-% does not exist", cart.getCartId()));
	}
	listOfCarts.remove(cart.getCartId());
    }

    public Cart retrieveCart(String cartId) {
	return listOfCarts.get(cartId);
    }

    public void updateCart(Cart cart, String cartId) {
	if (!listOfCarts.containsKey(cartId)) {
	    throw new IllegalArgumentException(String.format("Cart with ID-% does not exist", cart.getCartId()));
	}
	listOfCarts.put(cartId, cart);
    }

}
