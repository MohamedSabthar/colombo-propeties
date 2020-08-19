package com.colombo.properties.dto;

import java.util.List;

import com.colombo.properties.model.Location;

public class LocationsResponse extends Response {

	private List<Location> result;

	public List<Location> getResult() {
		return result;
	}

	public void setResult(List<Location> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "LocationsResponse [result=" + result + ", message=" + message + ", status=" + status + "]";
	}

}
