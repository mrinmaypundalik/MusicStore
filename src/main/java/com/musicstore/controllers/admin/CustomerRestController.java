package com.musicstore.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.musicstore.model.Customer;
import com.musicstore.model.Users;
import com.musicstore.service.CustomerService;
import com.musicstore.service.UsersService;

@RequestMapping("/rest/customer")
@Controller
public class CustomerRestController {

    @Autowired
    CustomerService customerService;
    
    @Autowired
    UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Customer> get() {
	return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void enableDisableCustomer(@PathVariable(value = "customerId") int customerId) {
	Customer customer = customerService.getCustomerById(customerId);
	Users user = usersService.getUserByUsername(customer.getUsername());
	if (customer.isEnabled()) {
	    customer.setEnabled(false);
	    user.setEnabled(false);
	} else {
	    customer.setEnabled(true);
	    user.setEnabled(true);
	}
	customerService.updateCustomer(customer);
	usersService.updateUsers(user);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal Request, please verify your payload")
    public void handleClientException(Exception e) {
	e.printStackTrace();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerException(Exception e) {
	e.printStackTrace();
    }
}