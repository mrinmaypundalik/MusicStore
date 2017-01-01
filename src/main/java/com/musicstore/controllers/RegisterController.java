package com.musicstore.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.musicstore.model.Customer;
import com.musicstore.service.CustomerService;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerCustomer(Model model) {
	Customer customer = new Customer();
	model.addAttribute("customer", customer);
	return "registerCustomer";
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String registerCustomer(@Valid @ModelAttribute(value="customer") Customer customer, BindingResult result,Model model){
	if(result.hasErrors()){
	    return "registerCustomer";
	}
	Set<Customer> customers = new HashSet<Customer>(customerService.getAllCustomers());
	if(customers.contains(customer)){
	    model.addAttribute("customerExists", "Username or Email already exists");
	    return "registerCustomer";
	}
	customer.setEnabled(true);
	customerService.addCustomer(customer);
	return "registerCustomerSuccess";
    }
}