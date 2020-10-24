package com.colombo.properties.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colombo.properties.dao.PropertyRepository;
import com.colombo.properties.dto.CreatePropertyRequest;
import com.colombo.properties.dto.FilterPropertyRequest;
import com.colombo.properties.dto.Response;
import com.colombo.properties.dto.UpdatePropertyDisplayRequest;
import com.colombo.properties.dto.UpdatePropertyRequest;
import com.colombo.properties.model.Property;
//import com.colombo.properties.dto.UpdatePropertyDisplayRequest;
import com.colombo.properties.service.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	@Autowired
	PropertyRepository propertyRepository;

	@PostMapping("/create")
	public Response createProperty(@RequestBody CreatePropertyRequest request) {

		Response response = null;
		try {
			Property property = propertyService.saveProperty(request);
			response = new Response("Property saved successfully", 201, property);

		} catch (Exception e) {
			System.out.println(e);
			response = new Response("Error saving propety", 400);
		}

		return response;
	}

	@PutMapping("/update-display")
	public Response updateStatusOfDisplay(@RequestBody UpdatePropertyDisplayRequest request) {

		Response response = null;
		try {
			propertyService.updatePropertyDisplay(request);

			response = new Response("Property display status updated", 200);
		} catch (Exception e) {
			System.out.println(e);
			response = new Response("Error updating property display status", 400);
		}

		return response;

	}

	@GetMapping("/display-accepted-only")
	public Response getAllAcceptedProperties() {

		List<Property> properties = propertyService.getPropertyByDisplay(true);
		Response response = new Response("Data loaded successfully", 200, properties);
		return response;
	}

	@GetMapping("/display-waiting-only")
	public Response getAllWaitingProperties() {

		List<Property> properties = propertyService.getPropertyByDisplay(false);
		Response response = new Response("Data loaded successfully", 200, properties);
		return response;
	}

	@GetMapping("/display-property/{id}")
	public Response getPropertyDetails(@PathVariable Long id) {
		Response response = null;
		try {
			Property property = propertyService.getProperty(id);
			response = new Response("Data loaded successfully", 200, property);
		} catch (NoSuchElementException e) {
			response = new Response("Data not found", 404, null);
		}

		return response;
	}

	@PostMapping("/filter")
	public Response filterProperty(@RequestBody FilterPropertyRequest request) {
		System.out.println(request);
		List<Property> properties = propertyService.filterProperty(request);
		Response response = new Response("test", 200, properties);
		System.out.println(properties);
		return response;
	}

	@GetMapping("/user/{id}")
	public Response getUserProperties(@PathVariable Long id) {
		Response response = null;
		try {
			List<Property> properties = propertyService.getUserProperties(id);
			response = new Response("Data loaded successfully", 200, properties);
		} catch (NoSuchElementException e) {
			response = new Response("Data not found", 404, null);
		}

		return response;
	}

	@DeleteMapping("/delete/{id}")
	public Response deleteProperty(@PathVariable long id) {

		propertyRepository.deleteById(id);

		return new Response("property delete", 200, null);
	}

	@PutMapping("/update/{id}")
	public Response updateProperty(@PathVariable Long id, @RequestBody UpdatePropertyRequest request) {

		Response response = null;

		try {
			Property property = propertyService.updateProperty(request);
			System.out.println(request.getTitle());
			response = new Response("Property updated successfully", 200, property);
		} catch (NoSuchElementException e) {
			response = new Response("Could not update property", 400, null);
		}

		return response;
	}

	@PostMapping("/filter-pending")
	public Response filterPendingProperty(@RequestBody FilterPropertyRequest request) {
		System.out.println(request);
		List<Property> properties = propertyService.filterPendingProperty(request);
		Response response = new Response("test", 200, properties);
		System.out.println(properties);
		return response;
	}

}
