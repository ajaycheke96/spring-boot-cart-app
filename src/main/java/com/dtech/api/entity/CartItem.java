package com.dtech.api.entity;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

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
}
