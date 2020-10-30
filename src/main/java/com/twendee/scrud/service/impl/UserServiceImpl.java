package com.twendee.scrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.twendee.scrud.entity.User;
import com.twendee.scrud.repository.UserRepository;
import com.twendee.scrud.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

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

	@Override
    public List<User> findPaginated(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<User> pagedResult = userRepository.findAll(paging);

        return pagedResult.toList();
    }
	@Override
    public Page<User> findAll(PageRequest pr){
        return userRepository.findAll(pr);
    }

	@Override
	public Page<User> findUserByName(Pageable pageable, String name) {
		return userRepository.findAllByNameContaining(pageable, name);
	}

	

	

}