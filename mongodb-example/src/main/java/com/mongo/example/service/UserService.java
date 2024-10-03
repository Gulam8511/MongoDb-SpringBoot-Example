package com.mongo.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.example.entity.User;
import com.mongo.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}
	public User createUser(User user)
	{
		User lastUser =  null;
		lastUser = userRepository.findTopByOrderByUserIdDesc();
		long lastUserId = 1;
		if(lastUser != null){
			lastUserId = lastUser.getUserId()+1;
		}
		user.setUserId(lastUserId);
		return userRepository.save(user);
	}
	public User updateUser(long userId,User user)
	{
		User existUser = userRepository.findById(userId).get();
		existUser.setName(user.getName());
		existUser.setEmail(user.getEmail());
		existUser.setPassword(user.getPassword());
		return userRepository.save(existUser);
	}
	public User findUserById(long userId)
	{
		return userRepository.findById(userId).get();
	}
	
	public void deleteUser(long userId)
	{
		 userRepository.deleteById(userId);
	}
	
}
