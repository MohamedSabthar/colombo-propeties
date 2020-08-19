package com.colombo.properties.dto;

public class FilterPropertyRequest {
	private Integer saleType;
	private Integer propertyType;
	private Integer location;

	public Integer getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}

	public Integer getSaleType() {
		return saleType;
	}

	public void setSaleType(Integer saleType) {
		this.saleType = saleType;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "FilterPropertyRequest [saleType=" + saleType + ", propertyType=" + propertyType + ", location="
				+ location + "]";
	}

}
