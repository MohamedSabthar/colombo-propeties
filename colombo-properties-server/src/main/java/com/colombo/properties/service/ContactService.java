
package com.colombo.properties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colombo.properties.dao.ContactusRepository;

import com.colombo.properties.dto.ContactUsRequest;

import com.colombo.properties.model.Contactus;

@Service
public class ContactService {

	@Autowired
	private ContactusRepository contactusRepository;

	public Contactus saveContact(ContactUsRequest request) {
		Contactus contactus = new Contactus(request);
		Contactus result = contactusRepository.save(contactus);
		return result;
	}

	public List<Contactus> getRecords() {
		List<Contactus> contacts = (List<Contactus>) contactusRepository.findAll();
		return contacts;
	}
}