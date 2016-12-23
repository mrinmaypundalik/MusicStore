package com.musicstore.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.musicstore.dao.CartDao;
import com.musicstore.dao.ProductsDao;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.model.Product;

@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    CartDao cartDao;

    @Autowired
    ProductsDao productsDao;

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart get(@PathVariable(value = "cartId") String cartId) {
	return cartDao.retrieveCart(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
	cartDao.updateCart(cart, cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
	cartDao.deleteCart(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addProduct(@PathVariable(value = "productId") String productId, HttpServletRequest request) {
	String sessionId = request.getSession(true).getId();
	Cart cart = cartDao.retrieveCart(sessionId);
	if (cart == null) {
	    cart = cartDao.createCart(new Cart(sessionId));
	}
	Product product = productsDao.getProductById(productId);
	cart.addCartItem(new CartItem(product, 1, product.getProductPrice()));
	cartDao.updateCart(cart, sessionId);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeProduct(@PathVariable(value = "productId") String productId, HttpServletRequest request) {
	String sessionId = request.getSession(true).getId();
	Cart cart = cartDao.retrieveCart(sessionId);
	if (cart == null) {
	    cart = cartDao.createCart(new Cart(sessionId));
	}
	Product product = productsDao.getProductById(productId);
	cart.removeCartItem(new CartItem(product, 1, product.getProductPrice()));
	cartDao.updateCart(cart, sessionId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request! Please check your payload")
    public void handleClientErrors(Exception e) {

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception e) {

    }

}
