package com.musicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.CustomerDao;
import com.musicstore.model.Customer;
import com.musicstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    
    public void addCustomer(Customer customer) {
	// TODO Auto-generated method stub
	customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
	// TODO Auto-generated method stub
	return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
	// TODO Auto-generated method stub
	return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername(String username) {
	// TODO Auto-generated method stub
	return customerDao.getCustomerByUsername(username);
    }

    @Override
    public void updateCustomer(Customer customer) {
	// TODO Auto-generated method stub
	customerDao.updateCustomer(customer);
    }
}
