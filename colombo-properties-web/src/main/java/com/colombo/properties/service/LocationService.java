package com.colombo.properties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.colombo.properties.dto.LocationsResponse;
import com.colombo.properties.model.Location;

@Service
public class LocationService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${backend.url}")
	private String serverBaseUrl;

	public List<Location> getAllLocation() {
		LocationsResponse locationsResponse = restTemplate.getForObject(serverBaseUrl + "location/all",
				LocationsResponse.class);

		List<Location> locations = locationsResponse.getResult();
		return locations;
	}
}
