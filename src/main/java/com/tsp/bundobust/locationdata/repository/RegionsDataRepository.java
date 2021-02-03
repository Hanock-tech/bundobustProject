package com.tsp.bundobust.locationdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsp.bundobust.repository.locationdata.RegionDetails;

@Repository
public interface RegionsDataRepository extends MongoRepository<RegionDetails, String> {
	@Query("{districtName: ?0}")
	RegionDetails findByDistrictName(String districtName);

}
