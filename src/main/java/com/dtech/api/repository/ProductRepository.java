package com.dtech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtech.api.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
