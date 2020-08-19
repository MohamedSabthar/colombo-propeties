package com.colombo.properties.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colombo.properties.dto.Response;
import com.colombo.properties.model.SaleType;
import com.colombo.properties.service.SaleTypeService;

@RestController
@RequestMapping("/sale-type")
public class SaleTypeController {

	@Autowired
	private SaleTypeService saleTypeService;

	@GetMapping("/all")
	public Response getAllSaleType() {
		List<SaleType> saleType = saleTypeService.getAllSaleType();
		Response response = new Response("Data loaded successfully", 200, saleType);
		return response;
	}

}
