package com.colombo.properties.model;

import java.util.List;

public class SaleType {

	private Integer id;
	private String type;

	private List<Property> propeties;

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

	public List<Property> getPropeties() {
		return propeties;
	}

	public void setPropeties(List<Property> propeties) {
		this.propeties = propeties;
	}

	@Override
	public String toString() {
		return "SaleType [id=" + id + ", type=" + type + ", propeties=" + propeties + "]";
	}
}
