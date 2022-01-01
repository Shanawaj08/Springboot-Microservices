package com.sandy.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandy.productservice.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>{

}
