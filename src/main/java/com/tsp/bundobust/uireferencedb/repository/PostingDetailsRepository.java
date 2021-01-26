package com.tsp.bundobust.uireferencedb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tsp.bundobust.uireferencedb.repository.data.UiPostingReferenceData;

@Repository
public interface PostingDetailsRepository extends MongoRepository<UiPostingReferenceData, String>{

}
