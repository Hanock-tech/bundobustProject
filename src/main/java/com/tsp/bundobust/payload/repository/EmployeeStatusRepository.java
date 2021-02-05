package com.tsp.bundobust.payload.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tsp.bundobust.employeestatusrepository.data.EmployeeStatus;

@Repository
public interface EmployeeStatusRepository extends MongoRepository<EmployeeStatus,String> {

}
