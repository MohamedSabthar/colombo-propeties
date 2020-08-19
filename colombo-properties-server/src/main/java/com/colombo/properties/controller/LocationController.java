package com.colombo.properties.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colombo.properties.dto.Response;
import com.colombo.properties.model.Location;
import com.colombo.properties.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@GetMapping("/all")
	public Response getAllLocation() {
		List<Location> locations = locationService.getAllLocation();
		Response response = new Response("Locations data loaded successfully", 200, locations);
		return response;
	}

}
