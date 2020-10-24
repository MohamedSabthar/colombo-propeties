package com.colombo.properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colombo.properties.dto.AuthRequest;
import com.colombo.properties.dto.CreatePropertyRequest;
import com.colombo.properties.dto.RegisterUserRequest;
import com.colombo.properties.dto.Response;
import com.colombo.properties.model.Property;
import com.colombo.properties.model.User;
import com.colombo.properties.security.JwtUtil;
import com.colombo.properties.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public Response registerUser(@RequestBody RegisterUserRequest request) {
		User user = userService.registerUser(request);
		
			try {
			System.out.println(request.getUsername());
			System.out.println(request.getPassword());
				//authenticationManager.authenticate(
					//	new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			} catch (Exception ex) {
				return new Response("token",403,null);
			}
			user = userService.getUser(request.getUsername());
			return new Response("token",200,jwtUtil.generateToken(request.getUsername(),user.getId(),user.getRole()));

	}
	
}
