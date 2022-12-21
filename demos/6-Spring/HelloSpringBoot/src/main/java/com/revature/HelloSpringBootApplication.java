package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.revature.models.Fruit;
import com.revature.revature.FruitRepo;

/*
 * With Spring Boot, we're following opinionated development. The idea is that Spring boot is going to make some 
 * 	base assumption for us so that we don't need configure ourselves. 
 * 
 * The benefit of this, is that it will speed up development because you don't need to write out so much boiler plate code. 
 */



@SpringBootApplication
public class HelloSpringBootApplication {

	@Autowired
	private FruitRepo fruip;
	
	@Bean
	FruitRepo createFruitRepo() {
		return this.fruip;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
		
		HelloSpringBootApplication hsba = new HelloSpringBootApplication();
		
		FruitRepo frup = hsba.createFruitRepo();
		
		
		frup.save(new Fruit(-27, "Apple", 50));
		
		
		System.out.println(hsba.fruip.findAll());
	}

}
