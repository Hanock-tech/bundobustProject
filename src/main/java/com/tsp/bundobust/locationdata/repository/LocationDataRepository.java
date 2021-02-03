package com.tsp.bundobust.locationdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tsp.bundobust.repository.locationdata.LocationDetails;

@Repository
public interface LocationDataRepository extends MongoRepository<LocationDetails,String> {

}
