package com.tsp.bundobust.eventdb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tsp.bundobust.eventrepository.data.EventData;


@Repository
public interface EventRepository extends MongoRepository<EventData, String> {

}
