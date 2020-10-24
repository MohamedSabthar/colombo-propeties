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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.colombo.properties.dto.CreatePropertyRequest;
import com.colombo.properties.dto.FilterPropertyRequest;
import com.colombo.properties.dto.UpdatePropertyRequest;
import com.colombo.properties.model.Location;
import com.colombo.properties.model.Property;
import com.colombo.properties.model.PropertyType;
import com.colombo.properties.model.SaleType;
import com.colombo.properties.service.AuthService;
import com.colombo.properties.service.LocationService;
import com.colombo.properties.service.PropertyService;
import com.colombo.properties.service.PropertyTypeService;
import com.colombo.properties.service.SaleTyperService;
import com.fasterxml.jackson.core.JsonProcessingException;

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
	@Autowired
	AuthService authService;

	// storage location to image directory
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/uploads";

	// method to pass role to view
	private ModelAndView setRole(ModelAndView mv) {
		if (authService.Jwt != null)
			mv.addObject("role", authService.parser(authService.Jwt).get("role"));
		else
			mv.addObject("role", null);
		return mv;
	}

	@GetMapping()
	public String home() {
		return "redirect:/";
	}

	@GetMapping("/{id}")
	public ModelAndView property(@PathVariable Long id) {

		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("property", propertyService.getProperty(id));
			// pass role
			mv = setRole(mv);
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

		// pass role
		mv = setRole(mv);
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

		// pass role
		mv = setRole(mv);

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
		Property result;
		try {
			result = propertyService.createProperty(request, authService.Jwt);
			if (result != null) {
				mv.addObject("property", result);
				mv.setViewName("redirect:/property/" + result.getId());
			} else {
				mv.addObject("result", "Error posting addvertisment");
				mv.setViewName("404");// set back page
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}

	@GetMapping("/create")
	public ModelAndView create() {
		var mv = new ModelAndView();

		// pass role
		mv = setRole(mv);

		if (authService.Jwt != null) {
			int userId = (int) authService.parser(authService.Jwt).get("id");

			mv.setViewName("create-property");
			mv.addObject("createProperty", new CreatePropertyRequest());
			mv.addObject("saleTypes", saleTyperService.getAllSaleType());
			mv.addObject("propertyTypes", propertyTypeService.getAllPropertyType());
			mv.addObject("locations", locationService.getAllLocation());
			mv.addObject("properties", propertyService.getUserProperties((long) userId, authService.Jwt));
			mv.addObject("user", userId); // pass the user id
		} else
			mv.setViewName("redirect:/login");
		return mv;
	}

	@PostMapping("/filter-pending")
	public ModelAndView filterPendingProperty(@ModelAttribute FilterPropertyRequest filterPropertyRequest) {

		ModelAndView mv = new ModelAndView();
		Map<String, String> search = new HashMap<String, String>();

		// pass role
		mv = setRole(mv);
		try {
			mv.addObject("properties",
					propertyService.getFilteredPendingProperties(filterPropertyRequest, authService.Jwt));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		mv.setViewName("filter-pending");

		return mv;
	}

	// faiz
	@GetMapping("/update/{id}")
	public ModelAndView update(@PathVariable Long id) {

		var mv = new ModelAndView();
		if (authService.Jwt != null) {
			// pass role
			mv = setRole(mv);
			int userId = (int) authService.parser(authService.Jwt).get("id");
			UpdatePropertyRequest request;
			try {
				request = new UpdatePropertyRequest(propertyService.getProperty(id));

				mv.setViewName("update-property");
				mv.addObject("createProperty", request);
				mv.addObject("saleTypes", saleTyperService.getAllSaleType());
				mv.addObject("propertyTypes", propertyTypeService.getAllPropertyType());
				mv.addObject("locations", locationService.getAllLocation());
				mv.addObject("properties", propertyService.getUserProperties((long) userId, authService.Jwt));
				mv.addObject("user", userId); // pass the user id
				mv.addObject("id", id);
			} catch (PageNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else
			mv.setViewName("redirect:/login");
		return mv;
	}

	@PostMapping("/update/{id}")
	public ModelAndView update(@ModelAttribute("createProperty") UpdatePropertyRequest request, @PathVariable Long id) {

		var mv = new ModelAndView();
		// pass role
		mv = setRole(mv);
		Property result;
		try {
			result = propertyService.updateProperty(request, authService.Jwt, id);
			if (result != null) {
				mv.addObject("property", result);
				mv.setViewName("redirect:/property/" + result.getId());
			} else {
				mv.addObject("result", "Error posting addvertisment");
				mv.setViewName("404");// set back page
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		
		var mv = new ModelAndView();
		// pass role
		mv = setRole(mv);
		if (authService.Jwt != null) {
			propertyService.delete(id, authService.Jwt);
			mv.setViewName("add-success");
		} else
			mv.setViewName("redirect:/login");

		return mv;
	}

}
