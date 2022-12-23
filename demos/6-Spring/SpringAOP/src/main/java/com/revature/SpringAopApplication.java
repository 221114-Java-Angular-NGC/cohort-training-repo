package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.models.Fruit;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		
//		Fruit f = new Fruit(1,"Kiwi",200);
//		System.out.println(f);
		
		SpringApplication.run(SpringAopApplication.class, args);
	}

}
