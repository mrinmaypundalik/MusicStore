package com.musicstore.dao;

import java.util.List;

import com.musicstore.model.Product;

public interface ProductsDao {

    void addProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();

    void deleteProduct(String id);
    
    void editProduct(Product product);
	
}
