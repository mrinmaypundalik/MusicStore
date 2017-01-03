package com.musicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.dao.CustomerDao;
import com.musicstore.model.Authorities;
import com.musicstore.model.Cart;
import com.musicstore.model.Customer;
import com.musicstore.model.Users;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();

	session.saveOrUpdate(customer);
	customer.getBillingAddress().setCustomer(customer);
	customer.getShippingAddress().setCustomer(customer);
	session.saveOrUpdate(customer.getBillingAddress());
	session.saveOrUpdate(customer.getShippingAddress());

	Users newUser = new Users();
	newUser.setCustomerId(customer.getCustomerId());
	newUser.setEnabled(true);
	newUser.setPassword(customer.getPassword());
	newUser.setUsername(customer.getUsername());
	session.saveOrUpdate(newUser);

	Authorities authorities = new Authorities();
	authorities.setUsername(customer.getUsername());
	authorities.setAuthority("ROLE_USER");
	session.saveOrUpdate(authorities);

	Cart cart = new Cart();
	cart.setCustomer(customer);
	session.saveOrUpdate(cart);

	customer.setCart(cart);
	session.saveOrUpdate(customer);

	session.flush();
    }

    public Customer getCustomerById(int customerId) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	return (Customer) session.get(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers() {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	Query query = session.createQuery("from Customer");
	List<Customer> customers = query.list();
	return customers;
    }

    public Customer getCustomerByUsername(String username) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	Query query = session.createQuery("from Customer where username=?");
	query.setString(0, username);
	Customer customer = (Customer) query.uniqueResult();
	return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(customer);
	session.flush();
    }
}
