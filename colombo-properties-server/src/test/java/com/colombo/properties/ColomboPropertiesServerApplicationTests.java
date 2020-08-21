package com.colombo.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.colombo.properties.dao.PropertyRepository;

@SpringBootTest
class ColomboPropertiesServerApplicationTests {

	@Autowired
	private PropertyRepository propertyRepository;

	@Test
	void contextLoads() {

	}

}
