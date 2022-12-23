package com.revature.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.revature.aspects.AspectExample;
import com.revature.service.FruitService;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public FruitService fruitService() {
		return new FruitService();
	}


    @Bean
    public AspectExample myAspect() {
        return new AspectExample();
    }
}
