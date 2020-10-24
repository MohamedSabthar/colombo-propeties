package com.colombo.properties;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.colombo.properties.controller.PropertyController;

@SpringBootApplication
public class ColomboPropertiesWebApplication {

	public static void main(String[] args) {
		new File(PropertyController.uploadDirectory).mkdir();
		SpringApplication.run(ColomboPropertiesWebApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	


}
