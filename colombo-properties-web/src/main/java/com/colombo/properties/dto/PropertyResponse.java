package com.colombo.properties.dto;

import com.colombo.properties.model.Property;

public class PropertyResponse extends Response {

	private Property result;

	public Property getResult() {
		return result;
	}

	public void setResult(Property result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PropertyResponse [message=" + message + ", status=" + status + ", result=" + result + "]";
	}
}
