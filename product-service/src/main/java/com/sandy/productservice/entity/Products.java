package com.sandy.productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Column
	private String productName;
	
	@Column
	private String description;
	
	@Column
	private Integer perUnitPrice;

	public Products() {
		
	}

	public Products(String productName, String description, Integer perUnitPrice) {
		this.productName = productName;
		this.description = description;
		this.perUnitPrice = perUnitPrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPerUnitPrice() {
		return perUnitPrice;
	}

	public void setPerUnitPrice(Integer perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}
	
	
	
}
