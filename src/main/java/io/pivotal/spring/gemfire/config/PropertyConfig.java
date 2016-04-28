package io.pivotal.spring.gemfire.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyConfig {

	@Value("${locators:localhost:10334}")
	public String locators;
}

