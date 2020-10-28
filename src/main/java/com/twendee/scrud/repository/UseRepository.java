package com.twendee.scrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twendee.scrud.entity.User;

@Repository
public interface UseRepository extends CrudRepository<User, String> {

}