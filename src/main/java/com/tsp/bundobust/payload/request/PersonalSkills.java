package com.tsp.bundobust.payload.request;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PersonalSkills {

	private LawAndOrderSkills lawAndOrderSkills;

	private ProfessionalSkills professionalSkills;

	private String publicPrivateRelation; // LOW/NORMAL/HIGH

	private CommunicationSkills communicationSkills;

	private List<String> languagesKnown; // TELUGU.TAMIL

	public LawAndOrderSkills getLawAndOrderSkills() {
		return lawAndOrderSkills;
	}

	public void setLawAndOrderSkills(LawAndOrderSkills lawAndOrderSkills) {
		this.lawAndOrderSkills = lawAndOrderSkills;
	}

	public ProfessionalSkills getProfessionalSkills() {
		return professionalSkills;
	}

	public void setProfessionalSkills(ProfessionalSkills professionalSkills) {
		this.professionalSkills = professionalSkills;
	}

	public String getPublicPrivateRelation() {
		return publicPrivateRelation;
	}

	public void setPublicPrivateRelation(String publicPrivateRelation) {
		this.publicPrivateRelation = publicPrivateRelation;
	}

	public CommunicationSkills getCommunicationSkills() {
		return communicationSkills;
	}

	public void setCommunicationSkills(CommunicationSkills communicationSkills) {
		this.communicationSkills = communicationSkills;
	}

	public List<String> getLanguagesKnown() {
		return languagesKnown;
	}

	public void setLanguagesKnown(List<String> languagesKnown) {
		this.languagesKnown = languagesKnown;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
