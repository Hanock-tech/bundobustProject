package com.tsp.bundobust.payload.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tsp.bundobust.models.Employee;


@Repository
public interface UserRepository extends MongoRepository<Employee, String> {
	
	Boolean existsByid(String id);
}
