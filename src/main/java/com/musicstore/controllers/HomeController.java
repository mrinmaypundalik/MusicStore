package com.musicstore.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.musicstore.dao.ProductsDao;
import com.musicstore.model.Product;

@Controller
public class HomeController {

    private final static String HOME_PAGE = "landingpage";
    private final static String PDP = "productsdisplaypage";
    private final static String PLP = "productslistpage";

    @Autowired
    private ProductsDao productsDao;

    @RequestMapping("/")
    public String home() {
	return HOME_PAGE;
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String displayProductInfo(@PathVariable String productId, Model model) {
	Product product = productsDao.getProductById(productId);
	model.addAttribute(product);
	return PDP;
    }

    @RequestMapping("/productslist")
    public String displayProductsList(Model model) {
	List<Product> products = productsDao.getAllProducts();
	model.addAttribute("products", products);
	return PLP;
    }
}
