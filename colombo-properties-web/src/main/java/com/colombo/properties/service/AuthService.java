package com.colombo.properties.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.colombo.properties.dto.AuthRequest;
import com.colombo.properties.dto.AuthResponse;
import com.colombo.properties.dto.LocationsResponse;
import com.colombo.properties.dto.PropertyResponse;
import com.colombo.properties.dto.RegisterUserRequest;
import com.colombo.properties.model.Location;
import com.colombo.properties.model.Token;
import com.colombo.properties.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuthService {

	public String Jwt;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${backend.url}")
	private String serverBaseUrl;

	public String getToken(AuthRequest request) {
		AuthResponse authResponse = restTemplate.postForObject(serverBaseUrl + "auth/login", request,
				AuthResponse.class);

		String token = authResponse.getResult();
		return token;
	}

	public Map<String, Object> parser(String jwt) {
		String[] parts = jwt.split("\\.", 0);

		byte[] bytes = Base64.getUrlDecoder().decode(parts[1]);
		String decodedString = new String(bytes, StandardCharsets.UTF_8);

		System.out.println("Decoded: " + decodedString);
		Map<String, Object> map = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			map = mapper.readValue(decodedString, Map.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	

	public String getRegisterToken(RegisterUserRequest request) {
		AuthResponse authResponse = restTemplate.postForObject(serverBaseUrl + "user/register",request,
				AuthResponse.class);

		String token = authResponse.getResult();
		return token;
	}
	
	 

}
