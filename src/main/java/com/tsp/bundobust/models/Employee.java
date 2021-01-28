package com.tsp.bundobust.models;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tsp.bundobust.payload.request.SignupRequest;
import com.tsp.bundobust.payload.request.UiPostingDetailsRequest;

@Document(collection = "employee_data")
public class Employee {

	@Id
	private String id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private Set<String> roles = new HashSet<>();

	private String sdpoName;

	private String districtName;

	private String divisonName;

	private String circleName;

	private String policeStationName;

	private String commissionerateName;

	private String zoneName;

	private String officeType;

	private UiPostingDetailsRequest UipostDetailsRequest;

	public Employee() {

	}

	public Employee(SignupRequest request) {

		this.id = request.getId();
		this.firstName = request.getFirstName();
		this.lastName = request.getLastName();
		this.password = request.getPassword();
		this.districtName = request.getDistrictName();
		this.sdpoName = request.getSdpoName();
		this.circleName = request.getCircleName();
		this.policeStationName = request.getPoliceStationName();
		this.commissionerateName = request.getCommissionerateName();
		this.divisonName = request.getDivisionName();
		this.zoneName = request.getZoneName();
		this.email = request.getEmail();
		this.officeType = request.getOfficeType();
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

	public String getSdpoName() {
		return sdpoName;
	}

	public void setSdpoName(String sdpoName) {
		this.sdpoName = sdpoName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDivisonName() {
		return divisonName;
	}

	public void setDivisonName(String divisonName) {
		this.divisonName = divisonName;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getPoliceStationName() {
		return policeStationName;
	}

	public void setPoliceStationName(String policeStationName) {
		this.policeStationName = policeStationName;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	public UiPostingDetailsRequest getUipostDetailsRequest() {
		return UipostDetailsRequest;
	}

	public void setUipostDetailsRequest(UiPostingDetailsRequest uipostDetailsRequest) {
		UipostDetailsRequest = uipostDetailsRequest;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
