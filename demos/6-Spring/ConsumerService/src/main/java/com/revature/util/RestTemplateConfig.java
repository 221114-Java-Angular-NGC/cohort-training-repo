package com.revature.util;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //Tell Spring that this class has methods that configure and create beans!
public class RestTemplateConfig {
	
	@Bean //Spring knows that this method will return a bean 
	public RestTemplate restTemplateGenerator(RestTemplateBuilder builder) {
		return builder.build(); //very basic configuration from us. 
	}

}
