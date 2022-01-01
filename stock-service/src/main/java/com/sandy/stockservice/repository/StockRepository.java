package com.sandy.stockservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandy.stockservice.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer> {

	Optional<StockEntity> findByProductCode(String productCode);
	
}
