package com.colombo.properties.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colombo.properties.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
