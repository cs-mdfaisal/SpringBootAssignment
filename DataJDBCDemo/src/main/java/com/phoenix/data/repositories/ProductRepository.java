package com.phoenix.data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.phoenix.data.entities.Product1;
/*
 * 
 * @description DAO Interface or Repository Interface
 */
public interface ProductRepository extends CrudRepository<Product1, Integer> {

}
