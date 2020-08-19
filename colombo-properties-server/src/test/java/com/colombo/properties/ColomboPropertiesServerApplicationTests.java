package com.colombo.properties;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.colombo.properties.dao.PropertyRepository;
import com.colombo.properties.model.Property;
import com.colombo.properties.model.PropertyType;
import com.colombo.properties.model.SaleType;

@SpringBootTest
class ColomboPropertiesServerApplicationTests {

	@Autowired
	private PropertyRepository propertyRepository;

	@Test
	void contextLoads() {

	}

}
