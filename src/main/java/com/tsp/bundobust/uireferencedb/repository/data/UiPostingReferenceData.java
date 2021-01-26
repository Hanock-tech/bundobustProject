package com.tsp.bundobust.uireferencedb.repository.data;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="ui_employee_creation_reference_data")
public class UiPostingReferenceData {
	
	@Id
	private String id;
	
	@Field("details")
	private List<PostingDetailsData> details;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<PostingDetailsData> getDetails() {
		return details;
	}

	public void setDetails(List<PostingDetailsData> details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
