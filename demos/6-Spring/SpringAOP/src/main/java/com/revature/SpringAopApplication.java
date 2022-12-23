package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.models.Fruit;
import com.revature.service.FruitService;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		
//		Fruit f = new Fruit(1,"Kiwi",200);
//		System.out.println(f);
		
		FruitService fs = SpringApplication.run(SpringAopApplication.class, args).getBean(FruitService.class);
		
		fs.randomMethod();
		fs.doubleMethod(27, 0);
		fs.intMethod(13);
	}

}
