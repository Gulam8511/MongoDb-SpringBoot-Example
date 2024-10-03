package com.mongo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.example.entity.Order;
import com.mongo.example.service.OrderService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/orders")
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrder()
	{
		return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
	}
	
	@PostMapping("/{userId}")
	public ResponseEntity<Order> createOrder(@RequestBody Order order,@PathVariable long userId)
	{
		Order savedOrder = orderService.createOrder(order, userId);
		return ResponseEntity.status(HttpStatus.OK).body(savedOrder);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<List<Order>> findOrderByUserId(@PathVariable long userId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findOrderByUserId(userId));
	}
	
}
