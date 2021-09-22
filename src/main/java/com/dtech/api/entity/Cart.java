package com.dtech.api.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor

@Entity
@Table(name = "cart_1999")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Integer id;
	@Column(name = "name", nullable = false)
	private String cartName;

	@JsonFormat(pattern = "YYYY-MM-DD 'T' HH:mm:ss", timezone = "IST")
	@Column(name = "created_at")
	private Timestamp createdAt;
	@JsonFormat(pattern = "YYYY-MM-DD 'T' HH:mm:ss", timezone = "IST")
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "cart_id")
	private List<CartItem> cartItems;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCartName() {
		return cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart(Integer id, String cartName, Timestamp createdAt, Timestamp updatedAt, List<CartItem> cartItems,
			User user) {
		super();
		this.id = id;
		this.cartName = cartName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.cartItems = cartItems;
		this.user = user;
	}

	public Cart() {
		super();
	}
}
