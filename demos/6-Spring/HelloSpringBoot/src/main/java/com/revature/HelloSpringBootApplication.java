package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.revature.models.Fruit;
import com.revature.revature.FruitRepo;
import com.revature.revature.RepoFactory;

/*
 * With Spring Boot, we're following opinionated development. The idea is that Spring boot is going to make some 
 * 	base assumption for us so that we don't need configure ourselves. 
 * 
 * The benefit of this, is that it will speed up development because you don't need to write out so much boiler plate code. 
 */



@SpringBootApplication
public class HelloSpringBootApplication {
	
	public static void main(String[] args) {
		FruitRepo frup = (FruitRepo) SpringApplication.run(HelloSpringBootApplication.class, args).getBean("fruitRepo");
		
		frup.save(new Fruit(-27, "Apple", 50));
		
		System.out.println(frup.findAll());
	}

}
