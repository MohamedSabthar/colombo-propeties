package com.colombo.properties.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.colombo.properties.dto.FilterPropertyRequest;
import com.colombo.properties.model.Location;
import com.colombo.properties.model.PropertyType;
import com.colombo.properties.model.SaleType;
import com.colombo.properties.service.LocationService;
import com.colombo.properties.service.PropertyService;
import com.colombo.properties.service.PropertyTypeService;
import com.colombo.properties.service.SaleTyperService;

import colombo.properties.exception.PageNotFoundException;

@Controller
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	PropertyService propertyService;
	@Autowired
	SaleTyperService saleTyperService;
	@Autowired
	PropertyTypeService propertyTypeService;
	@Autowired
	LocationService locationService;

	@GetMapping()
	public String home() {
		return "redirect:/";
	}

	@GetMapping("/{id}")
	public ModelAndView property(@PathVariable Long id) {

		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("property", propertyService.getProperty(id));
			mv.setViewName("property");
		} catch (PageNotFoundException e) {
			mv.setViewName("404");
		}
		System.out.println(mv);
		return mv;
	}

	@PostMapping("/filter")
	public ModelAndView filterProperty(@ModelAttribute FilterPropertyRequest filterPropertyRequest) {

		ModelAndView mv = new ModelAndView();
		Map<String, String> search = new HashMap<String, String>();

		mv.addObject("properties", propertyService.getFilteredProperties(filterPropertyRequest));

		List<SaleType> saleTypes = saleTyperService.getAllSaleType();
		mv.addObject("saleTypes", saleTypes);

		List<PropertyType> propertyTypes = propertyTypeService.getAllPropertyType();
		mv.addObject("propertyTypes", propertyTypes);

		List<Location> locations = locationService.getAllLocation();
		mv.addObject("locations", locations);

		if (filterPropertyRequest.getSaleType() == 0)
			search.put("searchSaleType", "All");
		else
			search.put("searchSaleType", saleTypes.stream()
					.filter(type -> filterPropertyRequest.getSaleType() == type.getId()).findFirst().get().getType());

		if (filterPropertyRequest.getPropertyType() == 0)
			search.put("searchPropertyType", "All");
		else
			search.put("searchPropertyType",
					propertyTypes.stream().filter(type -> filterPropertyRequest.getPropertyType() == type.getId())
							.findFirst().get().getType());
		if (filterPropertyRequest.getLocation() == 0)
			search.put("searchLocation", "All");
		else
			search.put("searchLocation",
					locations.stream().filter(type -> filterPropertyRequest.getLocation() == type.getId()).findFirst()
							.get().getLocation());

		mv.addObject("filterPropertyRequest", new FilterPropertyRequest());
		mv.addAllObjects(search);
		mv.setViewName("filter");

		return mv;
	}

}
