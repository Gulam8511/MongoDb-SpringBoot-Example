package com.mongo.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {

	@Id
	private long orderId;
	private String productName;
	private String decription;
	private double price;
	
	@DBRef
	private User user;
	private long userId;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(long orderId, String productName, String decription, double price, User user, long userId) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.decription = decription;
		this.price = price;
		this.user = user;
		this.userId = userId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

		
}
