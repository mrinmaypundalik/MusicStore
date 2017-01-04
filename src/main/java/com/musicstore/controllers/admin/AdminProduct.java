package com.musicstore.controllers.admin;

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

import com.musicstore.model.Product;
import com.musicstore.service.ProductService;

@Controller
@RequestMapping("/admin/product")
public class AdminProduct {

    private Path path;

    @Autowired
    private ProductService productService;

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
	List<Product> products = productService.getProductList();
	model.addAttribute("products", products);
	return "productInventory";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Model model) {

	Product product = new Product();
	product.setProductCategory("Instrument");
	product.setProductCondition("New");
	product.setProductStatus("Active");
	model.addAttribute("product", product);
	return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute(value = "product") Product product, BindingResult result,
	    HttpServletRequest request) {

	if (result.hasErrors()) {
	    return "addProduct";
	}
	productService.addProduct(product);
	MultipartFile image = product.getProductImage();

	if (image != null && !image.isEmpty()) {
	    try {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + product.getProductId() + ".jpg");
		System.out.println(path.toString());
		image.transferTo(new File(path.toString()));
	    } catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Error occured while saving image", e);
	    }
	}
	return "redirect:/admin/product/productInventory";
    }

    @RequestMapping("/editProduct/{productId}")
    public String editProduct(@PathVariable(value = "productId") int productId, Model model) {
	Product product = productService.getProductById(productId);
	model.addAttribute("product", product);
	return "editProduct";
    }

    @RequestMapping(value = "/editProduct", method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
	    HttpServletRequest request) {

	if (result.hasErrors()) {
	    return "editProduct";
	}

	productService.editProduct(product);
	MultipartFile image = product.getProductImage();

	if (image != null && !image.isEmpty()) {
	    try {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + product.getProductId() + ".jpg");
		image.transferTo(new File(path.toString()));
	    } catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Error occured while saving image", e);
	    }
	}
	return "redirect: /admin/product/productInventory";
    }
    
    @RequestMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable(value="productId") int productId,Model model,HttpServletRequest request){
	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	path = Paths.get(rootDirectory+"WEB-INF/resources/images/"+productId+".jpg");
	try {
	    Files.deleteIfExists(path);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	Product product = productService.getProductById(productId);
	productService.deleteProduct(product);
	return "redirect:/admin/product/productInventory";
    }

}
