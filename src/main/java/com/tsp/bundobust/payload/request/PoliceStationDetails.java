package com.tsp.bundobust.payload.request;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "policeStation_data")
public class PoliceStationDetails {
	@Id
	public String id;

	public Sectors sectors;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Sectors getSectors() {
		return sectors;
	}

	public void setSectors(Sectors sectors) {
		this.sectors = sectors;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
