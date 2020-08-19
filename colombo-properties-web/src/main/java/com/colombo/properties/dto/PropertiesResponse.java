package com.colombo.properties.dto;

import java.util.ArrayList;
import java.util.List;

import com.colombo.properties.model.Property;

public class PropertiesResponse extends Response {

	private List<Property> result;

	public List<Property> getResult() {
		return result;
	}

	public void setResult(ArrayList<Property> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + ", status=" + status + ", result=" + result + "]";
	}

}
