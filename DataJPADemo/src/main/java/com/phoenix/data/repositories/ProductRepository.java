package com.phoenix.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenix.data.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//custom finder method
	List<Product> findByName(String name);
	
}
