package com.musicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.CustomerOrderDao;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.model.CustomerOrder;
import com.musicstore.service.CartService;
import com.musicstore.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CartService cartService;
    
    @Autowired
    CustomerOrderDao customerOrderDao;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
	// TODO Auto-generated method stub
	customerOrderDao.addCustomerOrder(customerOrder);
    }

}
