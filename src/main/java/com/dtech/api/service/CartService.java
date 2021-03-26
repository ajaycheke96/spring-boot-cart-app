package com.dtech.api.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtech.api.entity.Cart;
import com.dtech.api.entity.User;
import com.dtech.api.repository.CartRepository;

@Service
@Transactional
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public List<Cart> findAllCarts() {
		return cartRepository.findAll();
	}

	public Cart findCartById(Integer id) {
		return cartRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cart not found of Id " + id));
	}

	public Cart findCartByUser(User user) {
		return cartRepository.findByUser(user);
	}

	public Cart saveCart(Cart cart) {
		Cart existedCart = cartRepository.findByUser(cart.getUser());
		if (existedCart != null && cart.getId() == null) {
			cart.setId(existedCart.getId());
		}
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (cart.getCreatedAt() == null)
			cart.setCreatedAt(currentTimestamp);
		cart.setUpdatedAt(currentTimestamp);

		cart.getCartItems().forEach(cartItem -> {
			if (cartItem.getCreatedAt() == null)
				cartItem.setCreatedAt(currentTimestamp);
			cartItem.setUpdatedAt(currentTimestamp);
		});

		return cartRepository.save(cart);
//		}
//		return existedCart;
	}

	public String deleteCart(Cart cart) {
		cartRepository.delete(cart);
		return "Cart has been deleted successfully.";
	}
}
