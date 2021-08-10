package com.phoenix.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/*
 * @author md.faisal
 */
//@Table("product1")
public class Product1 {

	@Id
	private int id;
	private String name;
	private String brand;
	private float price;
	
	public Product1() {
		// TODO Auto-generated constructor stub
	}

	public Product1(int id, String name, String brand, float price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
}
