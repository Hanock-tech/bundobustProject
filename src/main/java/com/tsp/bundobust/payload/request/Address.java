package com.tsp.bundobust.payload.request;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Address {

	private TemporaryAddress temporaryAddress;
	private PermenantAddress permenantAddress;

	public TemporaryAddress getTemporaryAddress() {
		return temporaryAddress;
	}

	public void setTemporaryAddress(TemporaryAddress temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}

	public PermenantAddress getPermenantAddress() {
		return permenantAddress;
	}

	public void setPermenantAddress(PermenantAddress permenantAddress) {
		this.permenantAddress = permenantAddress;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
