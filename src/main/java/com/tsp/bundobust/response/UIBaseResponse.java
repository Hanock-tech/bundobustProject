package com.tsp.bundobust.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.MDC;

public class UIBaseResponse {
	
	private String requestId = MDC.get("requestId");
	
	private Object data;
	
	public UIBaseResponse() {
		
	}
	
	public UIBaseResponse(Object obj) {
		this.data = obj;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
