package com.colombo.properties.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.colombo.properties.dto.ContactUsRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Contactus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String subject;
	private String message;
	private String email;
	
	public Contactus() {
	};
	
	public Contactus(ContactUsRequest request) {
		this.setName(request.getName());
		this.setSubject(request.getSubject());
		this.setEmail(request.getEmail());
		this.setMessage(request.getMessage());
	}

	@Override
	public String toString() {
		return "Contactus [id=" + id + ", name=" + name + ", subject=" + subject + ", message=" + message + ", email="
				+ email + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
