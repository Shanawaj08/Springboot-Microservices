package com.sandy.bookingservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service") //make sure to use eureka server name to make API call from booking to stock-service
public interface StockClient {
	
	@GetMapping("/api/stock/{productCode}")
	boolean stockCheck(@PathVariable("productCode") String productCode);

}
