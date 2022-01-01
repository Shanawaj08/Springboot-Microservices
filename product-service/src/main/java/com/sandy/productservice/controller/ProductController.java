package com.sandy.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sandy.productservice.entity.Products;
import com.sandy.productservice.repository.ProductRepository;


@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/products")
	@ResponseStatus(HttpStatus.OK)
	public List<Products> getAllProducts() {
		return productRepo.findAll();
	}
	
	@PostMapping("/products")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody Products product) {
		productRepo.save(product);
	}

}
