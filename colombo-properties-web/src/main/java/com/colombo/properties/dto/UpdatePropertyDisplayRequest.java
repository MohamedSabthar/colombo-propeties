package com.colombo.properties.dto;

public class UpdatePropertyDisplayRequest {

	private Long id; // if of the property
	private Boolean display; // new display status

	@Override
	public String toString() {
		return "UpdatePropertyDisplayRequest [id=" + id + ", display=" + display + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}
	
	public UpdatePropertyDisplayRequest(Long id, Boolean display) {
		this.setId(id);
		this.setDisplay(display);
	}
}
