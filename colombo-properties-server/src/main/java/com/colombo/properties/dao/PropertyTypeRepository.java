package com.colombo.properties.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colombo.properties.model.PropertyType;

@Repository
public interface PropertyTypeRepository extends CrudRepository<PropertyType, Integer> {

}
