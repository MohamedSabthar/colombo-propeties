package com.colombo.properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colombo.properties.dto.AuthRequest;
import com.colombo.properties.dto.Response;
import com.colombo.properties.model.User;
import com.colombo.properties.security.JwtUtil;
import com.colombo.properties.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public Response generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		System.out.print("hit");
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception ex) {
			return new Response("token", 403, null);
		}
		User user = userService.getUser(authRequest.getUsername());
		return new Response("token", 200,
				jwtUtil.generateToken(authRequest.getUsername(), user.getId(), user.getRole()));
	}
}
