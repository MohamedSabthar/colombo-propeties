package com.colombo.properties.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.colombo.properties.dto.RegisterUserRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String role;
	
	public User() {
		
	}
	
	public User(RegisterUserRequest request) {
		setUsername(request.getUsername());
		setPassword(request.getPassword());
		setEmail(request.getEmail());
		setPhone(request.getPhone());
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@JsonBackReference
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Property> propeties;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Property> getPropeties() {
		return propeties;
	}

	public void setPropeties(List<Property> propeties) {
		this.propeties = propeties;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", propeties=" + propeties + "]";
	}
	
	

}
