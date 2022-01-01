package com.sandy.productservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/categories")
@RefreshScope  //this will refresh all the @Value data in this bean after /actuator/refresh is called
public class CategoryController {
	
	@Value("${app.prop1}") //this value should get refresh
	private String prop1;
	
	@GetMapping("/prop")
	public String getProp1() {
		return this.prop1;
	}

}
