package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.service.FruitService;

@SpringBootApplication
public class ConsumerServiceApplication {

	public static void main(String[] args) {
		FruitService fs = (FruitService) SpringApplication.run(ConsumerServiceApplication.class, args).getBean("fruitService");
		
		System.out.println(fs.getFruitList());
	}

}
