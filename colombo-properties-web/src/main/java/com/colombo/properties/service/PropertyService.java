package com.colombo.properties.service;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.colombo.properties.dto.CreatePropertyRequest;
import com.colombo.properties.dto.FilterPropertyRequest;
import com.colombo.properties.dto.PropertiesResponse;
import com.colombo.properties.dto.PropertyResponse;
import com.colombo.properties.model.Property;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import colombo.properties.exception.PageNotFoundException;

@Service
public class PropertyService {

	@Autowired
	RestTemplate restTemplate;


	private HttpEntity<String> prepareWithJwt(String jwt, String body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + jwt);
		HttpEntity<String> httpEntity;
		if (body != null)
			httpEntity = new HttpEntity<String>(body, headers);
		else
			httpEntity = new HttpEntity<String>(headers);

		return httpEntity;
	}

	@Value("${backend.url}")
	private String serverBaseUrl;

	public List<Property> getAcceptedProperties() {

		List<Property> properties = null;
		try {
			PropertiesResponse propertiesResponse = restTemplate
					.getForObject(serverBaseUrl + "property/display-accepted-only", PropertiesResponse.class);
			properties = (List<Property>) propertiesResponse.getResult();
		} catch (ClassCastException e) {
			System.out.println(e.getStackTrace());
		}
		return properties;
	}

	public Property getProperty(Long id) throws PageNotFoundException {
		Property property = null;

		try {
			PropertyResponse propertiesResponse = restTemplate
					.getForObject(serverBaseUrl + "property/display-property/" + id, PropertyResponse.class);
			property = (Property) propertiesResponse.getResult();
			if (propertiesResponse.getStatus() == 404)
				throw new PageNotFoundException();
		} catch (ClassCastException e) {
			System.out.println(e.getStackTrace());
		}
		return property;

	}

	public List<Property> getFilteredProperties(FilterPropertyRequest request) {

		List<Property> properties = null;
		try {
			PropertiesResponse propertiesResponse = restTemplate.postForObject(serverBaseUrl + "property/filter",
					request, PropertiesResponse.class);
			properties = (List<Property>) propertiesResponse.getResult();
		} catch (ClassCastException e) {
			System.out.println(e.getStackTrace());
		}
		return properties;
	}

	public Property createProperty(CreatePropertyRequest request,String jwt) throws JsonProcessingException {

		try {
			String req = new ObjectMapper().writeValueAsString(request);
			System.out.println("hit : " + req);
			HttpEntity<String> jwtReq = prepareWithJwt(
					jwt,req);
			System.out.println("hit2");
			ResponseEntity<PropertyResponse> propertiesResponse =
//					restTemplate.postForObject(serverBaseUrl + "property/create", request,
//					PropertyResponse.class);
					restTemplate.exchange(serverBaseUrl + "property/create", HttpMethod.POST, jwtReq,
							PropertyResponse.class);
			System.out.println("hit3");
			if (// propertiesResponse.getStatus() == 201
			propertiesResponse.getStatusCode().equals(HttpStatus.CREATED))
//				return propertiesResponse.getResult();
				System.out.println("htter : " + propertiesResponse.getBody().getResult());
			return propertiesResponse.getBody().getResult();
		} catch (ClassCastException e) {
			System.out.println(e.getStackTrace());
		}
		return null;
	}

	public List<Property> getUserProperties(Long id,String jwt) {

		List<Property> properties = null;
		try {
//			PropertiesResponse propertiesResponse = restTemplate.getForObject(serverBaseUrl + "property/user/" + id,
//					PropertiesResponse.class);
//			properties = (List<Property>) propertiesResponse.getResult();
			HttpEntity<String> jwtReq = prepareWithJwt(
					jwt,null);

			ResponseEntity<PropertiesResponse> propertiesResponse =
//					restTemplate.postForObject(serverBaseUrl + "property/create", request,
//					PropertyResponse.class);
					restTemplate.exchange(serverBaseUrl + "property/user/" + id, HttpMethod.GET, jwtReq,
							PropertiesResponse.class);

			properties = (List<Property>) propertiesResponse.getBody().getResult();

		} catch (ClassCastException e) {
			System.out.println(e.getStackTrace());
		}
		return properties;
	}

}
