package com.sandy.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandy.bookingservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
