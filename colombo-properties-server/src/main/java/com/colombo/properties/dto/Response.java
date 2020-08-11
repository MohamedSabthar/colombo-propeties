package com.colombo.properties.dto;

public class Response {

	private String message;
	private Integer status;
	private Object result;

	public Response() {

	}

	public Response(String message, Integer code) {
		this.message = message;
		this.status = code;
	}

	public Response(String message, Integer code, Object result) {
		this(message, code);
		this.result = result;
	}

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

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + ", status=" + status + ", result=" + result + "]";
	}
}
