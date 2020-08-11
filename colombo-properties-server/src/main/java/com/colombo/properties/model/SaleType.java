package com.colombo.properties.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class SaleType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type;

	@JsonBackReference
	@OneToMany(mappedBy = "saleType", fetch = FetchType.EAGER)
	private List<Property> propeties;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Property> getPropeties() {
		return propeties;
	}

	public void setPropeties(List<Property> propeties) {
		this.propeties = propeties;
	}

	@Override
	public String toString() {
		return "SaleType [id=" + id + ", type=" + type + ", propeties=" + propeties + "]";
	}
}
