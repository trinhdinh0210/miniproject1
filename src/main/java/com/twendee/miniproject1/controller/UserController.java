package com.twendee.miniproject1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twendee.miniproject1.entity.User;
import com.twendee.miniproject1.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository repository;

	@PostMapping("/addUser")
	public String saveUser(@RequestBody User user) {
		repository.save(user);
		return "Added user with id : " + user.getId();
	}

	@GetMapping("/findAllUsers")
	public List<User> getUsers() {
		return repository.findAll();
	}

	@GetMapping("/findAllUsers/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return repository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		repository.deleteById(id);
		return "user deleted with id : " + id;
	}

}
