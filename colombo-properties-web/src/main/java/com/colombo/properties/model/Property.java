package com.colombo.properties.model;

import java.util.List;

//import com.colombo.properties.dto.CreatePropertyRequest;

public class Property {

	private Long id;
	private String title;
	private String description;
	private String address;
	private Double landSize;
	private Double propertySize;
	private Float price;
	private Boolean display; // display in the front-end if only true
	private Boolean status; // soled or not

	private PropertyType propertyType;

	private Location location;

	private SaleType saleType;

	private List<Image> images;

	private User user;

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

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public SaleType getSaleType() {
		return saleType;
	}

	public void setSaleType(SaleType saleType) {
		this.saleType = saleType;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", title=" + title + ", description=" + description + ", address=" + address
				+ ", landSize=" + landSize + ", propertySize=" + propertySize + ", price=" + price + ", display="
				+ display + ", status=" + status + ", propertyType=" + propertyType + ", location=" + location
				+ ", saleType=" + saleType + ", images=" + images + ", user=" + user + "]";
	}

}
