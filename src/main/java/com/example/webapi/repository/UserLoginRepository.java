package com.example.webapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.webapi.model.userlogin;

public interface UserLoginRepository extends MongoRepository<userlogin, String>{

	@Query("{'userName' : ?0}")
	userlogin finduserByUsername(String username);
}
