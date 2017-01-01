package com.musicstore.service;

import java.util.List;

import com.musicstore.model.Product;

public interface ProductService {

    List<Product> getProductList();
    
    Product getProductById(int productId);
    
    void addProduct(Product product);
    
    void editProduct(Product product);
    
    void deleteProduct(Product product);
}
