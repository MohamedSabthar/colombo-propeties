package com.colombo.properties.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colombo.properties.dao.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;
}
