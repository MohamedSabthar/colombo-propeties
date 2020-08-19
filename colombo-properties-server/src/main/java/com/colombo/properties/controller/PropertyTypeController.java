package com.colombo.properties.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colombo.properties.dto.CreatePropertyTypeRequest;
import com.colombo.properties.dto.Response;
import com.colombo.properties.model.PropertyType;
import com.colombo.properties.service.PropertyTypeService;

@RestController
@RequestMapping("/property-type")
public class PropertyTypeController {

	@Autowired
	private PropertyTypeService propertyTypeService;

	@PostMapping("/create")
	public Response createProperty(@RequestBody CreatePropertyTypeRequest request) {

		Response response = null;
		try {
			System.out.println(propertyTypeService);
			PropertyType propertyType = propertyTypeService.savePropertyType(request);
			response = new Response("Property Typed saved successfully", 201, propertyType);

		} catch (Exception e) {
			System.out.println(e);
			response = new Response("Error in saving property type", 400);
		}

		return response;
	}

	@GetMapping("/all")
	public Response getAllPropertyType() {
		List<PropertyType> propertyType = propertyTypeService.getAllPropertyTypes();
		Response response = new Response("PropertyType Loaded successfully", 200, propertyType);
		return response;
	}

}
