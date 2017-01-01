package com.musicstore.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musicstore.model.Customer;
import com.musicstore.service.CustomerService;
import com.musicstore.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHome {
    
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping
    public String adminPage(){
	return "admin";
    }
    
    @RequestMapping("/customer")
    public String customerManagement(Model model){
	List<Customer> customers = customerService.getAllCustomers();
	model.addAttribute("customers", customers);
	return "customerManagement";
    }
}
