package com.musicstore.dao;

import java.util.List;

import com.musicstore.model.Product;

public interface ProductsDao {

    void addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void deleteProduct(Product product);
    
    void editProduct(Product product);
	
}
