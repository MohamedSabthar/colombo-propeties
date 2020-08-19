package com.colombo.properties.model;

public class Image {

	private Long id;

	private String image;

	private Property property;

	public Image() {

	}

	public Image(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", image=" + image + ", property=" + property + "]";
	}
}
