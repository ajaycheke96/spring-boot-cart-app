package com.dtech.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtech.api.tenant.entity.Product;
import com.dtech.api.tenant.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Product findProductById(Integer id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Product not found of Id " + id));
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public String deleteProduct(Product product) {
		productRepository.delete(product);
		return "Product has been deleted successfully.";
	}
}
