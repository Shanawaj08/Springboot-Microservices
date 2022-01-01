package com.sandy.bookingservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sandy.bookingservice.client.StockClient;
import com.sandy.bookingservice.dto.OrderDTO;
import com.sandy.bookingservice.entity.Order;
import com.sandy.bookingservice.repository.OrderRepository;

@RestController
@RequestMapping("/api/bookings")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private StockClient stockClient;
	
	@PostMapping("/orders")
	@HystrixCommand(fallbackMethod = "fallbackForStockAPI")
	public String submitOrder(@RequestBody OrderDTO orderDto) {
		
		boolean inStock = orderDto.getOrderItems().stream()
				.allMatch(orderItem -> stockClient.stockCheck(orderItem.getCode()));
		if(inStock) {
			Order order = new Order(UUID.randomUUID().toString(), orderDto.getOrderItems());
			orderRepo.save(order);
			return "Order Placed";
		}
		else 
			return "Order Cannot be Placed";
		
	}
	
	private String fallbackForStockAPI() {
		return "Something went Wrong while fetching the product Stock, "
				+ "Please try after sometime";
	}

}
