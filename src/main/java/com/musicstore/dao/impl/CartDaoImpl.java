package com.musicstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.dao.CartDao;
import com.musicstore.model.Cart;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    SessionFactory sessionFactory;

    public Cart getCartById(int cartId) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	Cart cart = (Cart) session.get(Cart.class, cartId);
	return cart;
    }

    public void updateCart(Cart cart) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(cart);
	session.flush();
    }
}
