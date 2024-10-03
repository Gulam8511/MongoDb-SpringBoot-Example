package com.mongo.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.example.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
	
	 Order findTopByOrderByOrderIdDesc(); 
	 List<Order> findByUserId(long userId);
}
