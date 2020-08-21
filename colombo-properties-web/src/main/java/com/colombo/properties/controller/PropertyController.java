package com.colombo.properties.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.colombo.properties.dto.CreatePropertyRequest;
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

	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/uploads";

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

	@PostMapping("/create")
	public ModelAndView create(@RequestPart("files") MultipartFile[] files,
			@ModelAttribute("createProperty") CreatePropertyRequest request) {
		var mv = new ModelAndView();
		var images = new ArrayList<String>();
		StringBuilder fileNames = new StringBuilder();
		int counter = 0;
		for (MultipartFile file : files) {
			counter++;
			String imgName = request.getTitle() + "_" + request.getUser() + "_" + System.currentTimeMillis() + "_"
					+ counter + "_" + file.getOriginalFilename();
			images.add(imgName);
			Path fileNameAndPath = Paths.get(uploadDirectory, imgName);
			fileNames.append(file.getOriginalFilename() + " ");
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		request.setImages(images);

		if (propertyService.createProperty(request))
			mv.addObject("result", "Addvertisment created and ready for review");
		else
			mv.addObject("result", "Error posting addvertisment");

		mv.setViewName("404");// set back page
		return mv;
	}

	@GetMapping("/create")
	public ModelAndView create() {
		var mv = new ModelAndView();
		mv.setViewName("create-property");
		mv.addObject("createProperty", new CreatePropertyRequest());
		return mv;
	}

}
