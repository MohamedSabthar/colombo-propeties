package com.colombo.properties.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.colombo.properties.dao.PropertyTypeRepository;
import com.colombo.properties.model.PropertyType;

@Service
public class PropertyTypeService {

	@Autowired
	private PropertyTypeRepository propertyTypeRepository;

	public PropertyType getPropertyType(Integer id) {
		// here.get() is used for get the PropetyType from optional<PropertyType>
		return propertyTypeRepository.findById(id).get();
	}

	@Override
	public String toString() {
		return "PropertyTypeService [propertyTypeRepository=" + propertyTypeRepository + "]";
	}

}
