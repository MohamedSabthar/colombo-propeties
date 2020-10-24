package com.colombo.properties.dto;

import com.colombo.properties.model.Contactus;

public class ContactUsResponse  extends Response{
	private Contactus result;

	public Contactus getResult() {
		return result;
	}

	public void setResult(Contactus result) {
		this.result = result;
	}
	
}
