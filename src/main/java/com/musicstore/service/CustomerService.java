package com.musicstore.service;

import java.util.List;

import com.musicstore.model.Customer;

public interface CustomerService {

    void addCustomer(Customer customer);
    
    Customer getCustomerById(int customerId);
    
    List<Customer> getAllCustomers();
    
    Customer getCustomerByUsername(String username);
    
    void updateCustomer(Customer customer);
}
