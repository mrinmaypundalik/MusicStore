package com.musicstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6775780066971415193L;

    @Id
    @GeneratedValue
    private int customerId;

    @NotEmpty(message = "First Name cannot be empty")
    private String customerFirstName;

    @NotEmpty(message = "Last Name cannot be empty")
    private String customerLastName;

    @Email
    @NotEmpty(message = "email cannot be empty")
    private String customerEmail;

    private String customerContact;

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    public Customer() {
	setBillingAddress(new BillingAddress());
	setShippingAddress(new ShippingAddress());
    }

    public int getCustomerId() {
	return customerId;
    }

    public void setCustomerId(int customerId) {
	this.customerId = customerId;
    }

    public String getCustomerFirstName() {
	return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
	this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
	return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
	this.customerLastName = customerLastName;
    }

    @Column(unique = true)
    public String getCustomerEmail() {
	return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
    }

    public String getCustomerContact() {
	return customerContact;
    }

    public void setCustomerContact(String customerContact) {
	this.customerContact = customerContact;
    }

    @Column(unique = true)
    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public BillingAddress getBillingAddress() {
	return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
	this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
	return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
	this.shippingAddress = shippingAddress;
    }

    public Cart getCart() {
	return cart;
    }

    public void setCart(Cart cart) {
	this.cart = cart;
    }

    @Override
    public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	if (obj != null && (obj instanceof Customer)) {
	    Customer customer = (Customer) obj;
	    return customer.customerEmail.equals(customerEmail) || customer.username.equals(username);
	}
	return false;
    }

    @Override
    public int hashCode() {
	// TODO Auto-generated method stub
	return 31 * username.hashCode() >>> 2;
    }
}
