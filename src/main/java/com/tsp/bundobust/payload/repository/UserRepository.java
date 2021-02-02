package com.tsp.bundobust.payload.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsp.bundobust.models.Employee;


@Repository
public interface UserRepository extends MongoRepository<Employee, String> {
	
	Boolean existsByid(String id);

	// https://www.baeldung.com/queries-in-spring-data-mongodb       https://www.baeldung.com/spring-data-mongodb-projections-aggregations
	@Query("{policeStationName: ?0}")
	List<Employee> findByPoliceStationName(@Valid String policeStationName);
}
