package com.dtech.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtech.api.tenant.entity.CartItem;
import com.dtech.api.tenant.repository.CartItemRepository;

@Service
@Transactional
public class CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	public List<CartItem> findAllCartItems() {
		return cartItemRepository.findAll();
	}

	public CartItem findCartItemById(Integer id) {
		return cartItemRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("CartItem not found of Id " + id));
	}

	public CartItem saveCartItem(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	public String deleteCartItem(CartItem cartItem) {
		cartItemRepository.delete(cartItem);
		return "CartItem has been deleted successfully.";
	}

}
