package com.dtech.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtech.api.tenant.entity.Cart;
import com.dtech.api.tenant.entity.CartItem;
import com.dtech.api.tenant.entity.User;
import com.dtech.api.tenant.model.ApiResponse;
import com.dtech.api.tenant.service.CartItemService;
import com.dtech.api.tenant.service.CartService;

@RestController
@RequestMapping("/cart/api")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;

	// create cart
	@PostMapping("/createCart")
	public ApiResponse createCartForUser(@RequestBody Cart cart) {
		Cart cart2 = cartService.saveCart(cart);
		System.out.println(cart2);
		return new ApiResponse(LocalDateTime.now(), 200, "Cart created!", cart2);
	}

	// add cartItem
	@PostMapping("/addCartItem")
	public ApiResponse addCartItem(@RequestBody Cart cart) {
		Cart cart2 = cartService.saveCart(cart);
		System.out.println(cart2);
		return new ApiResponse(LocalDateTime.now(), 200, "CartItem added!", cart2);
	}

	// remove cartItem
	@PostMapping("/deleteCartItem")
	public ApiResponse deleteCartItem(@RequestBody CartItem cartItem) {
		return new ApiResponse(LocalDateTime.now(), 200, cartItemService.deleteCartItem(cartItem), null);
	}

	@GetMapping("/getCartByUser")
	public ApiResponse findCartByUser(@RequestBody User user) {
		return new ApiResponse(LocalDateTime.now(), 200, "Cart", cartService.findCartByUser(user));
	}

	@GetMapping("/{id}")
	public ApiResponse findCartById(@PathVariable Integer id) {
		return new ApiResponse(LocalDateTime.now(), 200, "Cart", cartService.findCartById(id));
	}
}
