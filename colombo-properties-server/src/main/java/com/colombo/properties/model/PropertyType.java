package com.colombo.properties.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.colombo.properties.dto.CreatePropertyTypeRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PropertyType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type;

	@JsonBackReference
	@OneToMany(mappedBy = "propertyType", fetch = FetchType.EAGER)
	private List<Property> properties;

	public PropertyType() {

	}

	public PropertyType(CreatePropertyTypeRequest request) {
		setType(request.getType());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "PropertyType [id=" + id + ", type=" + type + ", properties=" + properties + "]";
	}

}
