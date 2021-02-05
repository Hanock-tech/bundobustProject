package com.tsp.bundobust.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.UpdateResult;
import com.tsp.bundobust.dao.EventDao;
import com.tsp.bundobust.employeestatusrepository.data.EmployeeStatus;
import com.tsp.bundobust.eventrepository.data.EventData;
import com.tsp.bundobust.models.Employee;
import com.tsp.bundobust.payload.repository.EmployeeStatusRepository;

@Repository
public class EventDaoImpl implements EventDao {

	@Qualifier("eventDataMongoTemplate")
	@Autowired
	private MongoOperations mongoOperations;
	@Autowired
	private EmployeeStatusRepository employeeStatusRepository;

	@Override
	public boolean updateStaff(String eventId, List<Employee> employees) {

		String status = "NotAvailable";
		List<Employee> assignedEmployees = new ArrayList<Employee>();
		Query query = new Query();
		query.addCriteria(Criteria.where("eventId").is(eventId));
		for (Employee employeedata : employees) {
			Employee employeedetails = new Employee();
			employeedetails.setId(employeedata.getId());
			assignedEmployees.add(employeedetails);
		}
		UpdateResult updateResult = mongoOperations.upsert(query, new Update().push("assignedEmployees", assignedEmployees),
				EventData.class);
		if (updateResult.getModifiedCount() == 1) {
			for (Employee employeedata : employees) {
				EmployeeStatus employeestatus = new EmployeeStatus();
				employeestatus.setId(employeedata.getId());
				employeestatus.setStatus(status);
				employeeStatusRepository.save(employeestatus);
			}

		}
		return updateResult.wasAcknowledged();
	}

}
