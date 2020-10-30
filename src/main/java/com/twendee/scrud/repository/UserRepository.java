package com.twendee.scrud.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.twendee.scrud.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>  {
	
	Page<User> findAllByNameContaining(Pageable pageable, String name);


}