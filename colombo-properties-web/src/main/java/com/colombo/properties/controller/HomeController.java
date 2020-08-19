package com.colombo.properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.colombo.properties.dto.FilterPropertyRequest;
import com.colombo.properties.service.LocationService;
import com.colombo.properties.service.PropertyService;
import com.colombo.properties.service.PropertyTypeService;
import com.colombo.properties.service.SaleTyperService;

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

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("properties", propertyService.getAcceptedProperties());
		mv.addObject("saleTypes", saleTyperService.getAllSaleType());
		mv.addObject("propertyTypes", propertyTypeService.getAllPropertyType());
		mv.addObject("locations", locationService.getAllLocation());
		mv.addObject("filterPropertyRequest",new FilterPropertyRequest());
		mv.setViewName("home");
		System.out.println(propertyTypeService.getAllPropertyType());
		return mv;
	}

}
