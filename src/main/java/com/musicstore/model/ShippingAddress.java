package com.musicstore.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShippingAddress implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8008926175224075684L;

    @Id
    @GeneratedValue
    private int shippingAddressId;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    
    @OneToOne
    @JsonIgnore
    private Customer customer;

    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @Override
    public String toString() {
	return "ShippingAddress [billingAddressId=" + shippingAddressId + ", streetAddress=" + streetAddress + ", city="
		+ city + ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + "]";
    }
}
