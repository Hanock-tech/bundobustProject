package com.tsp.bundobust.policestationdb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tsp.bundobust.repository.data.PoliceStationData;

@Repository
public interface PoliceStationDetailsRepository extends MongoRepository<PoliceStationData, String> {

}
