package com.musicstore.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private String cartId;
    private Map<String, CartItem> cartItems;
    private double grandTotal;

    private Cart() {
	cartItems = new HashMap<String, CartItem>();
	grandTotal = 0;
    }

    public Cart(String cartId) {
	this();
	this.cartId = cartId;
    }

    public String getCartId() {
	return cartId;
    }

    public void setCartId(String cartId) {
	this.cartId = cartId;
    }

    public Map<String, CartItem> getCartItem() {
	return cartItems;
    }

    public void setCartItem(Map<String, CartItem> cartItem) {
	this.cartItems = cartItem;
    }

    public double getGrandTotal() {
	return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
	this.grandTotal = grandTotal;
    }

    private void updateGrandTotal() {
	double grandTotal = 0.0d;
	for (CartItem cartItem : cartItems.values()) {
	    grandTotal = grandTotal + cartItem.getProduct().getProductPrice();
	}
    }

    public void addCartItem(CartItem cartItem) {
	String productId = cartItem.getProduct().getProductId();

	if (cartItems.containsKey(productId)) {
	    CartItem existingCartItem = cartItems.get(productId);
	    existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
	    cartItems.put(productId, existingCartItem);
	} else {
	    cartItems.put(productId, cartItem);
	}

	updateGrandTotal();
    }

    public void removeCartItem(CartItem cartItem) {
	String productId = cartItem.getProduct().getProductId();
	cartItems.remove(productId);
	updateGrandTotal();
    }

}
