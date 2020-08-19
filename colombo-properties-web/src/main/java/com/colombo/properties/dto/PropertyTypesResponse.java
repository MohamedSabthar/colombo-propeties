package com.colombo.properties.dto;

import java.util.List;

import com.colombo.properties.model.PropertyType;

public class PropertyTypesResponse extends Response {
	private List<PropertyType> result;

	public List<PropertyType> getResult() {
		return result;
	}

	public void setResult(List<PropertyType> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PropertyTypesResponse [result=" + result + ", message=" + message + ", status=" + status + "]";
	}
}
