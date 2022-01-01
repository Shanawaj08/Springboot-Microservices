package com.sandy.bookingservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	
	@Id
	private Integer id;
	
	@Column
	private String orderNumber;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

	public Order() {
		
	}

	public Order(String orderNumber, List<OrderItem> orderItems) {
		super();
		this.orderNumber = orderNumber;
		this.orderItems = orderItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	

}
