package com.tsp.bundobust.policestationdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tsp.bundobust.payload.request.PoliceStationDetails;

@Repository
public interface PoliceStationDetailsRepository extends MongoRepository<PoliceStationDetails, String> {

}
