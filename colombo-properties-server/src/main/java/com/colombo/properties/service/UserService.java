package com.colombo.properties.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colombo.properties.dao.UserRepository;
import com.colombo.properties.dto.RegisterUserRequest;
import com.colombo.properties.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUser(Long id) {
		// here.get() is used for get the User from optional<User>
		return userRepository.findById(id).get();
	}

	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User registerUser(RegisterUserRequest request) {
		User user = new User(request);
		user.setRole("user");
		User result = userRepository.save(user);
		
		return result;
	}

}
