package com.colombo.properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.colombo.properties.dto.ContactUsRequest;
import com.colombo.properties.dto.FilterPropertyRequest;
import com.colombo.properties.service.AuthService;
import com.colombo.properties.service.ContactService;
import com.colombo.properties.service.LocationService;
import com.colombo.properties.service.PropertyService;
import com.colombo.properties.service.PropertyTypeService;
import com.colombo.properties.service.SaleTyperService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class HomeController {

	@Autowired
	PropertyService propertyService;
	@Autowired
	SaleTyperService saleTyperService;
	@Autowired
	PropertyTypeService propertyTypeService;
	@Autowired
	LocationService locationService;
	@Autowired
	ContactService contactService;
	@Autowired
	AuthService authService;
	
	private ModelAndView setRole(ModelAndView mv) {
		// pass role
		if (authService.Jwt != null)
			mv.addObject("role", authService.parser(authService.Jwt).get("role"));
		else
			mv.addObject("role", null);
		return mv;
	}

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		// pass role
				mv = setRole(mv);
		mv.addObject("properties", propertyService.getAcceptedProperties());
		mv.addObject("saleTypes", saleTyperService.getAllSaleType());
		mv.addObject("propertyTypes", propertyTypeService.getAllPropertyType());
		mv.addObject("locations", locationService.getAllLocation());
		mv.addObject("filterPropertyRequest", new FilterPropertyRequest());
	
		mv.setViewName("home");
		System.out.println(propertyTypeService.getAllPropertyType());
		return mv;
	}

	@GetMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("createContact", new ContactUsRequest());
		// pass role
		mv = setRole(mv);
		mv.setViewName("contact");
		return mv;
	}

	@PostMapping("/contact")
	public ModelAndView contactpost(@ModelAttribute("createContact") ContactUsRequest request) {
		try {
			contactService.createContact(request);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		// pass role
		mv = setRole(mv);
		mv.setViewName("contact");
		mv.setViewName("add-success");
		return mv;
	}

	@GetMapping("/contact-record")
	public ModelAndView contactRecord() {
		ModelAndView mv = new ModelAndView();
		// pass role
		mv = setRole(mv);
		if (authService.Jwt != null) {
			mv.addObject("records", contactService.getAllContactRecords(authService.Jwt));
		
			mv.setViewName("contacts-records");
		} else {
			mv.setViewName("redirect:/login");
			
		}
		return mv;
	}

}
