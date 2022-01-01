package com.sandy.stockservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandy.stockservice.entity.StockEntity;
import com.sandy.stockservice.repository.StockRepository;

@RestController
@RequestMapping("/api/stock")
public class StockController {
	
	@Autowired
	private StockRepository stockRepo;
	
	@GetMapping("/{productCode}")
	public boolean stockAvailability(@PathVariable("productCode") String productCode) {
		
		Optional<StockEntity> optStock = stockRepo.findByProductCode(productCode);
		//if product not found it will throw exception
		optStock.orElseThrow(() -> new RuntimeException("Cannot find Product " + productCode));
		
		//if product is found and quantity is greater than 0 it will return true else false
		return optStock.get().getQuantity() > 0;
		
	}

}
