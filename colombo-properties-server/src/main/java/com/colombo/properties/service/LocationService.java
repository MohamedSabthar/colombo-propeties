package com.colombo.properties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colombo.properties.dao.LocationRepository;
import com.colombo.properties.model.Location;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public Location getLocation(Integer id) {
		// here.get() is used for get the Location from optional<Location>
		return locationRepository.findById(id).get();
	}

	public List<Location> getAllLocation() {
		return (List<Location>) locationRepository.findAll();
	}
}
