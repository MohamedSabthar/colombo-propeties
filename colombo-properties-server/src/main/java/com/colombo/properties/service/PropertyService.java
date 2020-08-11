package com.colombo.properties.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colombo.properties.dao.ImageRepository;
import com.colombo.properties.dao.PropertyRepository;
import com.colombo.properties.dto.CreatePropertyRequest;
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

		request.getImages().forEach((img) -> img.setProperty(result));
		imageRepository.saveAll(request.getImages());

		System.out.println(result);
		return result;
	}

	public Property updatePropertyDisplay(UpdatePropertyDisplayRequest request) {
		Property property = propertyRepository.findById(request.getId()).get();
		property.setDisplay(request.getDisplay());
		// imageRepository.saveAll(property.getImages());
		return propertyRepository.save(property);
	}

}
