package com.musicstore.service.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.CartDao;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.model.Product;
import com.musicstore.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    public Cart getCartById(int cartId) {
	// TODO Auto-generated method stub
	return cartDao.getCartById(cartId);
    }

    public void updateCart(Cart cart) {
	// TODO Auto-generated method stub
	double grandTotal = getGrandTotal(cart);
	cart.setGrandTotal(grandTotal);
	cartDao.updateCart(cart);
    }

    private double getGrandTotal(Cart cart) {
	// TODO Auto-generated method stub
	List<CartItem> cartItems = cart.getCartItems();
	double grandTotal=0.0;
	for(CartItem cartItem:cartItems){
	    grandTotal += cartItem.getTotalPrice();
	}
	return grandTotal;
    }

    @Override
    public Cart validate(int cartId) throws IOException {
	// TODO Auto-generated method stub
	Cart cart = getCartById(cartId);
	if(cart==null || cart.getCartItems().size()==0){
	    throw new IOException(cartId+" ");
	}
	updateCart(cart);
	return cart;
    }
}
