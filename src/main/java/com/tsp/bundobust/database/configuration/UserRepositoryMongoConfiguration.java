//package com.tsp.bundobust.database.configuration;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import com.mongodb.client.MongoClient;
//
//@EnableMongoRepositories(basePackages = "com.tsp.bundobust.payload.repository",
//							mongoTemplateRef = "userDatabaseMongoTemplateRef")
//public class UserRepositoryMongoConfiguration {
//
//	@Bean
//	public MongoTemplate userDatabaseMongoTemplateRef(@Qualifier("mongo")MongoClient mongoClient) {
//
//		return new MongoTemplate(mongoClient, "employeeDatabase");
//
//	}
//}
