package com.mongo.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.example.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	 User findTopByOrderByUserIdDesc(); 
}
