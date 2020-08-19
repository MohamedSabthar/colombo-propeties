package com.colombo.properties.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colombo.properties.model.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
	public List<Property> findByDisplay(Boolean display);

	public List<Property> findByPropertyTypeIdAndSaleTypeIdAndLocationIdAndDisplay(Integer propertyTypeId,
			Integer saleTypeId, Integer locationId, Boolean display);

	public List<Property> findByPropertyTypeIdAndSaleTypeIdAndDisplay(Integer propertyTypeId, Integer saleTypeId,
			Boolean display);

	public List<Property> findBySaleTypeIdAndLocationIdAndDisplay(Integer saleTypeId, Integer locationId,
			Boolean display);

	public List<Property> findByPropertyTypeIdAndLocationIdAndDisplay(Integer propertyTypeId, Integer locationId,
			Boolean display);

	public List<Property> findByPropertyTypeIdAndDisplay(Integer propertyTypeId, Boolean display);

	public List<Property> findByLocationIdAndDisplay(Integer locationId, Boolean display);

	public List<Property> findBySaleTypeIdAndDisplay(Integer saleTypeId, Boolean display);
}
