package com.colombo.properties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colombo.properties.dao.ImageRepository;
import com.colombo.properties.dao.PropertyRepository;
import com.colombo.properties.dto.CreatePropertyRequest;
import com.colombo.properties.dto.FilterPropertyRequest;
import com.colombo.properties.dto.UpdatePropertyDisplayRequest;
//import com.colombo.properties.dto.CreatePropertyRequest;
//import com.colombo.properties.dto.UpdatePropertyDisplayRequest;
import com.colombo.properties.model.Property;

@Service
public class PropertyService {

	@Autowired
	private PropertyRepository propertyRepository;
	@Autowired
	private ImageRepository imageRepository;

	public Property getProperty(Long id) {
		// here.get() is used for get the Property from optional<Property>
		return propertyRepository.findById(id).get();
	}

	public Property saveProperty(CreatePropertyRequest request) {
		Property property = new Property(request);
		Property result = propertyRepository.save(property);
		try {
			request.getImages().forEach((img) -> img.setProperty(result));
			imageRepository.saveAll(request.getImages());
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(result);
		return result;
	}

	public Property updatePropertyDisplay(UpdatePropertyDisplayRequest request) {
		Property property = propertyRepository.findById(request.getId()).get();
		property.setDisplay(request.getDisplay());
		// imageRepository.saveAll(property.getImages());
		return propertyRepository.save(property);
	}

	public List<Property> getPropertyByDisplay(Boolean isDisplayed) {
		return propertyRepository.findByDisplay(isDisplayed);
	}

	public List<Property> filterProperty(FilterPropertyRequest request) {
		if (request.getLocation() == 0 && request.getPropertyType() == 0 && request.getLocation() == 0)
			return propertyRepository.findByDisplay(true);
		if (request.getLocation() == 0 && request.getPropertyType() == 0)
			return propertyRepository.findBySaleTypeIdAndDisplay(request.getSaleType(), true);
		if (request.getLocation() == 0 && request.getSaleType() == 0)
			return propertyRepository.findByPropertyTypeIdAndDisplay(request.getPropertyType(), true);
		if (request.getPropertyType() == 0 && request.getSaleType() == 0)
			return propertyRepository.findByLocationIdAndDisplay(request.getLocation(), true);
		if (request.getPropertyType() == 0)
			return propertyRepository.findBySaleTypeIdAndLocationIdAndDisplay(request.getSaleType(),
					request.getLocation(), true);
		if (request.getLocation() == 0)
			return propertyRepository.findByPropertyTypeIdAndSaleTypeIdAndDisplay(request.getPropertyType(),
					request.getSaleType(), true);
		if (request.getSaleType() == 0)
			return propertyRepository.findByPropertyTypeIdAndLocationIdAndDisplay(request.getPropertyType(),
					request.getLocation(), true);
		return propertyRepository.findByPropertyTypeIdAndSaleTypeIdAndLocationIdAndDisplay(request.getPropertyType(),
				request.getSaleType(), request.getLocation(), true);

	}

}
