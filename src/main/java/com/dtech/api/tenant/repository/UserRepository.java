package com.dtech.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtech.api.tenant.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
