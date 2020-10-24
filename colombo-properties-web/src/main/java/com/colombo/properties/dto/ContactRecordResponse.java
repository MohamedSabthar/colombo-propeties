package com.colombo.properties.dto;

import java.util.List;

import com.colombo.properties.model.Contactus;

public class ContactRecordResponse extends Response {
	private List<Contactus> result;

	public List<Contactus> getResult() {
		return result;
	}

	public void setResult(List<Contactus> result) {
		this.result = result;
	}
}
