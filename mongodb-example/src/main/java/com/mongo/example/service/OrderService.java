package com.mongo.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.example.entity.Order;
import com.mongo.example.entity.User;
import com.mongo.example.repository.OrderRepository;
import com.mongo.example.repository.UserRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Order createOrder(Order order, long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        long lastOrderId=1;
        Order lastOrder = null;
        lastOrder = orderRepository.findTopByOrderByOrderIdDesc();
        if(lastOrder != null) {
        	lastOrderId = lastOrder.getOrderId()+1;
        }
        order.setOrderId(lastOrderId);
        order.setUser(user);
        order.setUserId(userId);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public List<Order> findOrderByUserId(long userId)
    {
    	return orderRepository.findByUserId(userId);
    }
    
}
