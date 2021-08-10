package com.phoenix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenix.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//custom finder method
	List<Product> findByName(String name);
	
	List<Product>findByNameAndBrand(String name,String brand);
	
	
}
