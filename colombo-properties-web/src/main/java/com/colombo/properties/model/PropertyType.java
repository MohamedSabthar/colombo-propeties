package com.colombo.properties.model;

import java.util.List;

public class PropertyType {

	private Integer id;
	private String type;

	private List<Property> properties;

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
