package com.twendee.scrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.twendee.scrud.entity.User;

@Service
public interface UserService {
    List<User> getAllUser();

    void saveUser(User user);

    void deleteUser(String id);

    Optional<User> findUserById(String id);
    
    Page<User> findAll(PageRequest pageRequest);
    
    List<User> findPaginated(int pageNo, int pageSize);
    
    List<User> search(String p);
    
}