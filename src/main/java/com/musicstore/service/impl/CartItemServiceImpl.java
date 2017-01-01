package com.musicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.CartItemDao;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemDao cartItemDao;
    @Override
    public void addCartItem(CartItem cartItem) {
	// TODO Auto-generated method stub
	cartItemDao.addCartItem(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
	// TODO Auto-generated method stub
	cartItemDao.removeCartItem(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
	// TODO Auto-generated method stub
	cartItemDao.removeAllCartItems(cart);
    }

}
