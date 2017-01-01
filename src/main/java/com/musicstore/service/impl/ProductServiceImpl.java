package com.musicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.ProductsDao;
import com.musicstore.model.Product;
import com.musicstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsDao productsDao;
    
    public List<Product> getProductList() {
	// TODO Auto-generated method stub
	return productsDao.getAllProducts();
    }

    public Product getProductById(int productId) {
	// TODO Auto-generated method stub
	return productsDao.getProductById(productId);
    }

    public void addProduct(Product product) {
	// TODO Auto-generated method stub
	productsDao.addProduct(product);
    }

    public void editProduct(Product product) {
	// TODO Auto-generated method stub
	productsDao.editProduct(product);
    }

    public void deleteProduct(Product product) {
	// TODO Auto-generated method stub
	productsDao.deleteProduct(product);
    }

}
