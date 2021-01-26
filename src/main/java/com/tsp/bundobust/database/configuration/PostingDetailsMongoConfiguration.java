package com.tsp.bundobust.database.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.tsp.bundobust.uireferencedb.repository",
mongoTemplateRef = "uiReferenceDbMongoTemplate")
public class PostingDetailsMongoConfiguration {
	
	  @Bean
	    public MongoTemplate uiReferenceDbMongoTemplate(@Qualifier("mongo")MongoClient mongo) throws Exception {
	        return new MongoTemplate(mongo, "uiReferenceDatabase");
	    }

}
