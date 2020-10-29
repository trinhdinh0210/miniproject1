package com.twendee.scrud.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.twendee.scrud.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>  {
	
	List<User> findByNameContaining(String p);


}