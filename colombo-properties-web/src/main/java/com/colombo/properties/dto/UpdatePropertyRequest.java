package com.colombo.properties.dto;

import com.colombo.properties.model.Property;

public class UpdatePropertyRequest {

	private Long id;
	private String title;
	private String description;
	private String address;
	private Double landSize;
	private Double propertySize;
	private Float price;

	private Integer propertyType;
	private Integer location;
	private Integer saleType;
	private Long user;
	
	public UpdatePropertyRequest() {
		
	}
	
	public UpdatePropertyRequest(Property property) {
		
		this.setId(property.getId());
		this.setTitle(property.getTitle());
		this.setDescription(property.getDescription());
		this.setAddress(property.getAddress());
		this.setLandSize(property.getLandSize());
		this.setPropertySize(property.getPropertySize());
		this.setPrice(property.getPrice());
		this.setPropertyType(property.getPropertyType().getId());
		this.setLocation(property.getLocation().getId());
		this.setSaleType(property.getSaleType().getId());
		this.setUser(property.getUser().getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLandSize() {
		return landSize;
	}

	public void setLandSize(Double landSize) {
		this.landSize = landSize;
	}

	public Double getPropertySize() {
		return propertySize;
	}

	public void setPropertySize(Double propertySize) {
		this.propertySize = propertySize;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Integer getSaleType() {
		return saleType;
	}

	public void setSaleType(Integer saleType) {
		this.saleType = saleType;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CreatePropertyRequest [title=" + title + ", description=" + description + ", address=" + address
				+ ", landSize=" + landSize + ", propertySize=" + propertySize + ", price=" + price + ", propertyType="
				+ propertyType + ", location=" + location + ", saleType=" + saleType + ", user="
				+ user + "]";
	}
}
