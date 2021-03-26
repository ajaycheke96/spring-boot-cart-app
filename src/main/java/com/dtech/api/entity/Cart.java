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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

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
}
