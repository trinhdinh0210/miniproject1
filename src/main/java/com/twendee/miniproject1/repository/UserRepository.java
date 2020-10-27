package com.twendee.miniproject1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.twendee.miniproject1.entity.User;


@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

}
