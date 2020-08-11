package com.colombo.properties.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colombo.properties.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
