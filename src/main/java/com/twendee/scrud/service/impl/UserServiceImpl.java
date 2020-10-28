package com.twendee.scrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twendee.scrud.entity.User;
import com.twendee.scrud.repository.UseRepository;
import com.twendee.scrud.service.UserService;


@Service
public class UserServiceImpl implements UserService {
    @Autowired private UseRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }
}