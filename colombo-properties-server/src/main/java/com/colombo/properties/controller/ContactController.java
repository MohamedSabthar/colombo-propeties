package com.colombo.properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colombo.properties.dto.ContactUsRequest;
import com.colombo.properties.dto.Response;
import com.colombo.properties.model.Contactus;
import com.colombo.properties.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	ContactService contactService;

	@PostMapping("/create")
	public Response contact(@RequestBody ContactUsRequest request) {

		Response response = null;
		try {
			Contactus contactus = contactService.saveContact(request);
			response = new Response("Property saved successfully", 201, contactus);

		} catch (Exception e) {
			System.out.println(e);
			response = new Response("Error saving propety", 400);
		}

		return response;
	}

	@GetMapping("/all")
	public Response contact() {
		return new Response("contact records", 200, contactService.getRecords());
	}

}
