package com.colombo.properties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colombo.properties.dao.PropertyTypeRepository;
import com.colombo.properties.dto.CreatePropertyTypeRequest;
import com.colombo.properties.model.PropertyType;

@Service
public class PropertyTypeService {

	@Autowired
	private PropertyTypeRepository propertyTypeRepository;

	public PropertyType getPropertyType(Integer id) {
		// here.get() is used for get the PropetyType from optional<PropertyType>
		return propertyTypeRepository.findById(id).get();
	}

	public PropertyType savePropertyType(CreatePropertyTypeRequest request) {

		PropertyType propertyType = new PropertyType(request);
		PropertyType result = propertyTypeRepository.save(propertyType);

		System.out.println(result);
		return result;

	}

	public List<PropertyType> getAllPropertyTypes() {
		return (List<PropertyType>) propertyTypeRepository.findAll();
	}

}
