package com.colombo.properties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colombo.properties.dao.SaleTypeRepository;
import com.colombo.properties.model.SaleType;

@Service
public class SaleTypeService {

	@Autowired
	private SaleTypeRepository saleTypeRepository;

	public SaleType getSaleType(Integer id) {
		// here.get() is used for get the SaleType from optional<SaleType>
		return saleTypeRepository.findById(id).get();
	}

	public List<SaleType> getAllSaleType() {
		return (List<SaleType>) saleTypeRepository.findAll();
	}
}
