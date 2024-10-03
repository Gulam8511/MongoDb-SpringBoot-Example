package com.mongo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.example.entity.User;
import com.mongo.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAllUsers()
	{
		List<User> userList = userService.findAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user)
	{
		User savedUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!"+savedUser);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> findUserById(@PathVariable long userId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(userId));
	}
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUsers(@PathVariable long userId,@RequestBody User user)
	{
		userService.updateUser(userId, user);
		return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable long userId)
	{
		userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
	}
	
}
