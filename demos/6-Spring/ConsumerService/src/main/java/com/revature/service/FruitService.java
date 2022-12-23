package com.revature.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Fruit;

/*
 * Typically, a service will use the DAO layer within the project to communicate to the database. 
 * 
 * But our FruitService is going to communicate to SpringAOP's controllers, effectively we're using another
 * 	service to maintain the database. 
 */
@Service
public class FruitService {
	
//	private FruitDao fdao;
	
	@Autowired
	private RestTemplate restTemplate; //using this dependency instead to consume our Spring AOP service 
//										(Note: We need to tell Spring to create it for us!)
	
	public List<Fruit> getFruitList(){
		
		URI uri = URI.create("http://localhost:8888/api/fruits");
		
		Fruit[] allTheFruit = this.restTemplate.getForObject(uri, Fruit[].class);
		
		List<Fruit> fruitList =  Arrays.asList(allTheFruit);
		
		return fruitList;
	}

}
