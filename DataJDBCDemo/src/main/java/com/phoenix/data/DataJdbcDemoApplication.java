package com.phoenix.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phoenix.data.entities.Product1;
import com.phoenix.data.repositories.ProductRepository;

@SpringBootApplication
public class DataJdbcDemoApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DataJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		//Get All Products
		Iterable<Product1> products = productRepo.findAll();
		products.forEach(System.out::println);
	
	}

}
