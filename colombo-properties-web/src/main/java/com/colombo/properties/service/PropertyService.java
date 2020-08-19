package com.colombo.properties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.colombo.properties.dto.FilterPropertyRequest;
import com.colombo.properties.dto.PropertiesResponse;
import com.colombo.properties.dto.PropertyResponse;
import com.colombo.properties.model.Property;

import colombo.properties.exception.PageNotFoundException;

@Service
public class PropertyService {

	@Autowired
	RestTemplate restTemplate;

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

}
