package com.colombo.properties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.colombo.properties.dto.PropertyTypesResponse;
import com.colombo.properties.model.PropertyType;

@Service
public class PropertyTypeService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${backend.url}")
	private String serverBaseUrl;

	public List<PropertyType> getAllPropertyType() {
		PropertyTypesResponse propertyTypesResponse = restTemplate.getForObject(serverBaseUrl + "property-type/all",
				PropertyTypesResponse.class);

		List<PropertyType> saleTypes = propertyTypesResponse.getResult();
		return saleTypes;
	}
	
	

}
