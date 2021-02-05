package com.tsp.bundobust.dao;

import java.util.List;

import com.tsp.bundobust.models.Employee;

public interface EventDao {
	
	void updateStaff(String eventId, List<Employee> employees);

}
