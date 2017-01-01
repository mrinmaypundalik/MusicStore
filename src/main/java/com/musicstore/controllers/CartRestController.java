package com.musicstore.controllers;

import java.util.List;

import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.model.Customer;
import com.musicstore.model.Product;
import com.musicstore.service.CartItemService;
import com.musicstore.service.CartService;
import com.musicstore.service.CustomerService;
import com.musicstore.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    CartItemService cartItemService;

    @RequestMapping(value="/{cartId}",method=RequestMethod.GET)
    public @ResponseBody Cart get(@PathVariable(value = "cartId") int cartId) {
	return cartService.getCartById(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void add(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User user) {
	Customer customer = customerService.getCustomerByUsername(user.getUsername());
	Cart cart = customer.getCart();
	List<CartItem> cartItems = cart.getCartItems();
	Product product = productService.getProductById(productId);
	for (CartItem cartItem : cartItems) {
	    if (cartItem.getProduct().getProductId() == productId) {
		cartItem.setQuantity(cartItem.getQuantity() + 1);
		cartItem.setTotalPrice(cartItem.getQuantity() * product.getProductPrice());
		cartItemService.addCartItem(cartItem);
		return;
	    }
	}
	CartItem cartItem = new CartItem();
	cartItem.setProduct(product);
	cartItem.setQuantity(1);
	cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
	cartItem.setCart(cart);
	cartItemService.addCartItem(cartItem);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeProduct(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User user) {
	Customer customer = customerService.getCustomerByUsername(user.getUsername());
	Cart cart = customer.getCart();
	List<CartItem> cartItems = cart.getCartItems();
	for (CartItem cartItem : cartItems) {
	    if (cartItem.getProduct().getProductId() == productId) {
		cartItemService.removeCartItem(cartItem);
		return;
	    }
	}
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartId") int cartId) {
	Cart cart = cartService.getCartById(cartId);
	cartItemService.removeAllCartItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal Request, please verify your payload")
    public void handleClientException(Exception e) {

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerException(Exception e) {

    }
}