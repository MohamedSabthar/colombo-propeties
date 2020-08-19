package com.colombo.properties.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.colombo.properties.dto.CreatePropertyRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.colombo.properties.dto.CreatePropertyRequest;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private String address;
	private Double landSize;
	private Double propertySize;
	private Float price;
	private Boolean display; // display in the front-end if only true
	private Boolean status; // soled or not

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	private PropertyType propertyType;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	private Location location;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	private SaleType saleType;

	@JsonManagedReference
	@OneToMany(mappedBy = "property", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> images;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	// Temperer
	public Property() {
	}

	public Property(CreatePropertyRequest request) {
		setTitle(request.getTitle());
		setDescription(request.getDescription());
		setAddress(request.getAddress());
		setLandSize(request.getLandSize());
		setPropertySize(request.getPropertySize());
		setPrice(request.getPrice());
		setDisplay(false);
		setStatus(false); // setting status to not-sold

		setPropertyType(request.getPropertyType());
		setLocation(request.getLocation());
		setSaleType(request.getSaleType());
		setUser(request.getUser());
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

	@JsonIgnore
	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public void setPropertyType(Integer propertyType) {
		PropertyType temp = new PropertyType();
		temp.setId(propertyType);
		this.propertyType = temp;
	}

	public Location getLocation() {
		return location;
	}

	@JsonIgnore
	public void setLocation(Location location) {
		this.location = location;
	}

	public void setLocation(Integer location) {
		Location temp = new Location();
		temp.setId(location);
		this.location = temp;
	}

	public SaleType getSaleType() {
		return saleType;
	}

	@JsonIgnore
	public void setSaleType(SaleType saleType) {
		this.saleType = saleType;
	}

	public void setSaleType(Integer saleType) {
		SaleType temp = new SaleType();
		temp.setId(saleType);
		this.saleType = temp;
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

	@JsonIgnore
	public void setUser(User user) {
		this.user = user;
	}

	public void setUser(Long user) {
		User temp = new User();
		temp.setId(user);
		this.user = temp;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", title=" + title + ", description=" + description + ", address=" + address
				+ ", landSize=" + landSize + ", propertySize=" + propertySize + ", price=" + price + ", display="
				+ display + ", status=" + status + ", propertyType=" + propertyType.getType() + ", location="
				+ location.getLocation() + ", saleType=" + saleType.getType() + ", images=" + images.size() + ", user="
				+ user.getId() + "]";
	}

}
