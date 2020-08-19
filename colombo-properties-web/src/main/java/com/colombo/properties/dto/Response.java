package com.colombo.properties.dto;

public class Response {

	protected String message;
	protected Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer code) {
		this.status = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
