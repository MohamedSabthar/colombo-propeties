

package com.colombo.properties.service;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.colombo.properties.dto.ContactRecordResponse;
import com.colombo.properties.dto.ContactUsRequest;
import com.colombo.properties.dto.ContactUsResponse;
import com.colombo.properties.dto.CreatePropertyRequest;
import com.colombo.properties.dto.FilterPropertyRequest;
import com.colombo.properties.dto.PropertiesResponse;
import com.colombo.properties.dto.PropertyResponse;
import com.colombo.properties.model.Contactus;
import com.colombo.properties.model.Property;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import colombo.properties.exception.PageNotFoundException;

@Service
public class ContactService {

	@Autowired
	RestTemplate restTemplate;
	






	@Value("${backend.url}")
	private String serverBaseUrl;
	

	private HttpEntity<String> prepareWithJwt(String jwt, String body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + jwt);
		HttpEntity<String> httpEntity;
		if (body != null)
			httpEntity = new HttpEntity<String>(body, headers);
		else
			httpEntity = new HttpEntity<String>(headers);

		return httpEntity;
	}


	public Contactus createContact(ContactUsRequest request) throws JsonProcessingException {

	
		ContactUsResponse contactUsResponse =
					restTemplate.postForObject(serverBaseUrl + "contact/create", request,
					ContactUsResponse.class);
					
			if ( contactUsResponse.getStatus() == 201)
				return contactUsResponse.getResult();
				System.out.println("htter : " + contactUsResponse.getResult());
			return null;
	
	}
	
	public List<Contactus> getAllContactRecords(String jwt) {

		List<Contactus> contactus = null;
		try {

			HttpEntity<String> jwtReq = prepareWithJwt(
					jwt,null);

			ResponseEntity<ContactRecordResponse> contactRecordResponse =
//					restTemplate.postForObject(serverBaseUrl + "property/create", request,
//					PropertyResponse.class);
					restTemplate.exchange(serverBaseUrl + "contact/all/", HttpMethod.GET, jwtReq,
							ContactRecordResponse.class);

			contactus = (List<Contactus>) contactRecordResponse.getBody().getResult();

		} catch (ClassCastException e) {
			System.out.println(e.getStackTrace());
		}
		return contactus;
	}
}