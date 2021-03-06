package com.musicstore.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5478784336942404211L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @NotEmpty(message = "Product Name Required")
    private String productName;

    private String productCategory;

    private String productDescription;

    @Min(value = 0, message = "Invalid Product Price")
    private double productPrice;

    private String productCondition;

    private String productStatus;

    @Min(value = 0, message = "Invalid Stock Quantity")
    private int unitInStock;

    private String productManufacturer;

    /*
     * @Transient private MultipartFile productImage;
     */

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItems;

    private String productImageUrl;

    public String getProductImageUrl() {
	return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
	this.productImageUrl = productImageUrl;
    }

    public List<CartItem> getCartItems() {
	return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
	this.cartItems = cartItems;
    }

    /*
     * public MultipartFile getProductImage() { return productImage; }
     * 
     * public void setProductImage(MultipartFile productImage) {
     * this.productImage = productImage; }
     */

    public int getProductId() {
	return productId;
    }

    public void setProductId(int productId) {
	this.productId = productId;
    }

    public String getProductName() {
	return productName;
    }

    public void setProductName(String productName) {
	this.productName = productName;
    }

    public String getProductCategory() {
	return productCategory;
    }

    public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
    }

    public String getProductDescription() {
	return productDescription;
    }

    public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
    }

    public double getProductPrice() {
	return productPrice;
    }

    public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
    }

    public String getProductCondition() {
	return productCondition;
    }

    public void setProductCondition(String productCondition) {
	this.productCondition = productCondition;
    }

    public String getProductStatus() {
	return productStatus;
    }

    public void setProductStatus(String productStatus) {
	this.productStatus = productStatus;
    }

    public int getUnitInStock() {
	return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
	this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
	return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
	this.productManufacturer = productManufacturer;
    }
}
