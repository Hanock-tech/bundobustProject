package com.tsp.bundobust.database.configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.tsp.bundobust.payload.repository",
							mongoTemplateRef = "mongoTemplate")
public class UserRepositoryMongoConfiguration {

}
