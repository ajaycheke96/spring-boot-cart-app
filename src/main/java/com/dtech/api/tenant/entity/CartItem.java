package com.dtech.api.tenant.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor

@Entity
@Table(name = "cart_item_1999")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@JsonFormat(pattern = "YYYY-MM-DD 'T' HH:mm:ss", timezone = "IST")
	@Column(name = "created_at")
	private Timestamp createdAt;
	@JsonFormat(pattern = "YYYY-MM-DD 'T' HH:mm:ss", timezone = "IST")
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public CartItem(Integer id, String name, Timestamp createdAt, Timestamp updatedAt, Product product) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.product = product;
	}

	public CartItem() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
