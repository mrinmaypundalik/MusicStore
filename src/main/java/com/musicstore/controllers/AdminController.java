package com.musicstore.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.musicstore.dao.ProductsDao;
import com.musicstore.model.Product;

@Controller
public class AdminController {

    @Autowired
    private ProductsDao productsDao;

    private Path path;
    
    @RequestMapping("/admin")
    public String admin() {
	return "admin";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String displayAddProduct(Model model) {
	Product product = new Product();
	model.addAttribute("product", product);
	return "addProduct";
    }

    @RequestMapping("/admin/productInventory")
    public String displayProductInventory(Model model) {
	List<Product> productList = productsDao.getAllProducts();
	model.addAttribute("products", productList);
	return "productInventory";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
	    HttpServletRequest request) {

	if (result.hasErrors()) {
	    return "addProduct";
	}
	productsDao.addProduct(product);
	MultipartFile image = product.getProductImage();
	String root = request.getSession().getServletContext().getRealPath("/");
	path = Paths.get(root + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".jpg");

	if (image != null && !image.isEmpty()) {
	    try {
		image.transferTo(new File(path.toString()));
	    } catch (IllegalStateException e) {

		e.printStackTrace();
	    } catch (IOException e) {

		e.printStackTrace();
	    }
	}

	return "redirect: /admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable String productId, Model model, HttpServletRequest request) {

	String root = request.getSession().getServletContext().getRealPath("/");
	path = Paths.get(root + "\\WEB-INF\\resources\\images\\" + productId + ".jpg");

	productsDao.deleteProduct(productId);

	if (Files.exists(path)) {
	    try {
		Files.delete(path);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	return "redirect: /admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable String productId, Model model) {

	Product product = productsDao.getProductById(productId);

	model.addAttribute(product);
	return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
	    HttpServletRequest request, Model model) {

	if (result.hasErrors()) {
	    return "editProduct";
	}
	MultipartFile image = product.getProductImage();
	String root = request.getSession().getServletContext().getRealPath("/");
	Path path = Paths.get(root + "/WEB-INF/resources/images/" + product.getProductId() + ".jpg");

	if (image != null && !image.isEmpty()) {
	    try {
		image.transferTo(new File(path.toString()));
	    } catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Image store Failed", e);
	    }
	}
	productsDao.editProduct(product);

	return "redirect: /admin/productInventory";
    }
    
}
