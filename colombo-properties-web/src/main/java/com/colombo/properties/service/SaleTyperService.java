package com.colombo.properties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.colombo.properties.dto.SaleTypesResponse;
import com.colombo.properties.model.SaleType;

@Service
public class SaleTyperService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${backend.url}")
	private String serverBaseUrl;

	public List<SaleType> getAllSaleType() {
		SaleTypesResponse saleTypesResponse = restTemplate.getForObject(serverBaseUrl + "sale-type/all",
				SaleTypesResponse.class);

		List<SaleType> saleTypes = saleTypesResponse.getResult();
		return saleTypes;
	}
}
