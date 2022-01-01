package com.sandy.bookingservice.dto;

import java.util.List;

import com.sandy.bookingservice.entity.OrderItem;

public class OrderDTO {
	
	private List<OrderItem> orderItems;

	public OrderDTO() {
		
	}

	public OrderDTO(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	

}
