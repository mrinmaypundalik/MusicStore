package com.musicstore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.dao.CartItemDao;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;

@Transactional
@Repository
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addCartItem(CartItem cartItem) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(cartItem);
	session.flush();
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	session.delete(cartItem);
	session.flush();
    }

    @Override
    public void removeAllCartItems(Cart cart) {
	// TODO Auto-generated method stub
	List<CartItem> cartItems = cart.getCartItems();
	for(CartItem cartItem:cartItems){
	    removeCartItem(cartItem);
	}
    }
}
