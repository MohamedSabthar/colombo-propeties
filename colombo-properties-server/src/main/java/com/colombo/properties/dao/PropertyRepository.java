package com.colombo.properties.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colombo.properties.model.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
	List<Property> findByDisplay(Boolean display);

}
