package com.twendee.scrud.service;

import com.twendee.scrud.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    void saveUser(User user);

    void deleteUser(String id);

    Optional<User> findUserById(String id);
}