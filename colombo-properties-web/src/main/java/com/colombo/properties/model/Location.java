package com.colombo.properties.model;

import java.util.List;

public class Location {

	private Integer id;
	private String location;

	private List<Property> properties;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", location=" + location + ", properties=" + properties + "]";
	}

}
