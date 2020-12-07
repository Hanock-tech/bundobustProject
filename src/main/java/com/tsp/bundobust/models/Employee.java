package com.tsp.bundobust.models;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tsp.bundobust.payload.request.SignupRequest;


@Document(collection = "employee_data")
public class Employee {
	
	@Id
	private String id;

	private String firstName;
	
	private String lastName;
	
	private String email;

	private String password;

	private Set<String> roles = new HashSet<>();

	private String sdpoId;

	private String sdpoName;

	private String districtId;

	private String districtName;

	private String divisionId;

	private String divisonName;

	private String circleId;

	private String circleName;

	private String policeStationId;

	private String policeStationName;
	
	private String commissionerateName;
	
	private String commissionerateId;
	
	private String reportingOfficerId;
	
	private String reportingOfficeTitle;
	
	private String reportingOfficerFirstName;
	
	private String reportingOfficerLastName;


	public Employee() {
		
	}
	
	public Employee(SignupRequest request) {
		
		this.id = request.getId();
		this.firstName = request.getFirstName();
		this.lastName = request.getLastName();
		this.password = request.getPassword();
		this.districtId = request.getDistrictId();
		this.districtName = request.getDistrictName();
		this.sdpoId = request.getSdpoId();
		this.sdpoName = request.getSdpoName();
		this.divisionId = request.getDivisionId();
		this.divisonName = request.getDivisonName();
		this.circleId = request.getCircleId();
		this.circleName = request.getCircleName();
		this.policeStationId = request.getPoliceStationId();
		this.policeStationName = request.getPoliceStationName();
		this.commissionerateId = request.getCommissionerateId();
		this.commissionerateName = request.getCommissionerateName();
		this.email = request.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getCommissionerateName() {
		return commissionerateName;
	}

	public void setCommissionerateName(String commissionerateName) {
		this.commissionerateName = commissionerateName;
	}

	public String getCommissionerateId() {
		return commissionerateId;
	}

	public void setCommissionerateId(String commissionerateId) {
		this.commissionerateId = commissionerateId;
	}
	
	public String getSdpoName() {
		return sdpoName;
	}

	public void setSdpoName(String sdpoName) {
		this.sdpoName = sdpoName;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
