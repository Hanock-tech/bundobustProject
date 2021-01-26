package com.tsp.bundobust.uireferencedb.repository.data;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class PostingDetailsData {
	
	@Field("sectionHeader")
	private String sectionHeader;
	
	@Field("sectionHeaderValues")
	private List<SectionHeaderValuesData> sectionHeaderValues;
	
	public String getSectionHeader() {
		return sectionHeader;
	}

	public void setSectionHeader(String sectionHeader) {
		this.sectionHeader = sectionHeader;
	}

	public List<SectionHeaderValuesData> getSectionHeaderValues() {
		return sectionHeaderValues;
	}

	public void setSectionHeaderValues(List<SectionHeaderValuesData> sectionHeaderValues) {
		this.sectionHeaderValues = sectionHeaderValues;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
