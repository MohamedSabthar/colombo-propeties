package com.colombo.properties.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colombo.properties.model.SaleType;

@Repository
public interface SaleTypeRepository extends CrudRepository<SaleType, Integer> {

}
