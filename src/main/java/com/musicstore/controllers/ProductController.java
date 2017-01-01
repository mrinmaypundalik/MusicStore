package com.musicstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicstore.model.Product;
import com.musicstore.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @RequestMapping("/productlist")
    public String getProductList(Model model){
	List<Product> products = productService.getProductList();
	model.addAttribute("products",products);
	return "productslistpage";
    }
    
    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable(value="productId") int productId,Model model){
	
	Product product = productService.getProductById(productId);
	model.addAttribute("product", product);
	return "productsdisplaypage";
    }
    
    @RequestMapping("/productlist/filter")
    public String getProductByCategory(@RequestParam(value="searchCondition") String searchCondition, Model model ){
	List<Product> products = productService.getProductList();
	model.addAttribute("products",products);
	model.addAttribute("searchCondition", searchCondition);
	return "productslistpage";
	
    }
}
