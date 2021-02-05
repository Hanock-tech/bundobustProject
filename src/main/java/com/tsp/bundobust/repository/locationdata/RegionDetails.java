package com.tsp.bundobust.repository.locationdata;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "regions_data")
public class RegionDetails {
	private String districtName;
	private List<Sdpos> sdpos;
    private  String zoneDetails;
    private String divisionName;
    
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public List<Sdpos> getSdpos() {
		return sdpos;
	}

	public void setSdpos(List<Sdpos> sdpos) {
		this.sdpos = sdpos;
	}
	
	public String getZoneDetails() {
		return zoneDetails;
	}

	public void setZoneDetails(String zoneDetails) {
		this.zoneDetails = zoneDetails;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
