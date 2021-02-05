package com.tsp.bundobust.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;

import com.tsp.bundobust.dao.EventDao;
import com.tsp.bundobust.eventrepository.data.EventData;
import com.tsp.bundobust.models.Employee;

@Repository
public class EventDaoImpl implements EventDao{
	
	@Qualifier("eventDataMongoTemplate")
	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public void updateStaff(String eventId, List<Employee> employees) {
		
		Query query = null;
		
		UpdateDefinition upd = null;
		mongoOperations.upsert(query, upd, EventData.class);
		
	}

}
