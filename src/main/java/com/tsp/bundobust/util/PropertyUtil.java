package com.tsp.bundobust.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources(value = { @PropertySource(value = { "errorMessages.properties" }) })
public class PropertyUtil {
	
	@Autowired
	private Environment env;
	
	@Value(value = "${bundobust.roles: COMMISSIONER,DCP,ACP,SHO}")
	private String[] roles;
	
	public String getValue(String key) {
		return env.getProperty(key);
	}
	
	public Set<String> getAvailableRoles() {
		
		List<String> asList = Arrays.asList(roles);
		return new HashSet<String>(asList);
	}

}
