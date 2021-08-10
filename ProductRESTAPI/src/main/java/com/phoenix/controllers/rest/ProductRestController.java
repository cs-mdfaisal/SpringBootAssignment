package com.phoenix.controllers.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.phoenix.entities.Product;
import com.phoenix.repositories.ProductRepository;
/*
 * RESTful web service for product resource using spring web MVC
 */
@RequestMapping("/products")
@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productRepo.findAll();
		
	}
	@GetMapping("/{pid}")
	public Product getById(@PathVariable("pid") int id) {
		//Optional<Product> op = productRepo.findById();
		return productRepo.findById(id).get();
	}
//insert new product if new id or update existing product
	@PutMapping
	public String addProduct(@RequestBody Product product) {
		product = productRepo.save(product);
		return "New product "+product.getId() +" is added successfully";
		
	}
	//update existing product
	@PostMapping
	public String updateProduct(@RequestBody Product product) {
		Optional<Product> op = productRepo.findById(product.getId());
		if(op.isPresent()) {
			product = productRepo.save(product);
			return "product "+ product.getId()+"is updated successfully!";
		}
		else
			return "Sorry! product is not found";
			
		
	}
	@DeleteMapping
	public String deleteProduct(Product product) {
		
		Optional<Product> op = productRepo.findById(product.getId());
		if(op.isPresent()) {
			productRepo.delete(product);
			return "product "+ product.getId()+"is deleted successfully!";
		}
		else
			return "Sorry! product is not found";
		}
	@PostMapping("/add-form")
	public RedirectView addFormData(@RequestParam("nm") String name,@RequestParam("brand") String brand,@RequestParam("price") float price) {
	//public String addFormData(@RequestParam("nm") String name,@RequestParam("brand") String brand,@RequestParam("price") float price) {
	Product p = new Product();
	p.setName(name);
	p.setBrand(brand);
	p.setPrice(price);
	p=productRepo.save(p);
	//return "Form data with product"+p.getId()+ "is added successfully";
	//return "redirect:/success";//does not work for RestController
	return new RedirectView("success");
	
	}
	@GetMapping("/{nm}/{br}")
	public List<Product> getProductsByNameAndBrand(@PathVariable("nm") String name,@PathVariable("br") String brand) {
		return productRepo.findByNameAndBrand(name, brand);
	}
	@GetMapping("/success")
	public ResponseEntity<String> getSuccessMessage(){
		return ResponseEntity.ok("Congratulations new product is added succesfully");
		
	}
}
