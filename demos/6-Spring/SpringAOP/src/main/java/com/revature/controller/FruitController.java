package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Fruit;

/*
 * Spring Boot DevTools will automatically update your project when you make changes to it. 
 * Very convinient when in development. 
 */

@RestController
@RequestMapping("/api")
public class FruitController {
	
	private static List<Fruit> fruitList = new ArrayList<>();
	
	@GetMapping("/fruits")
	public List<Fruit> selectAll(){
		return fruitList;
	}
	
	@GetMapping("/fruit/{index}")
	public Fruit selectFruitByIndex(@PathVariable int index) {
		return fruitList.get(index);
	}
	
	@PostMapping("/fruit")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addFruit(@RequestBody Fruit f) {
		fruitList.add(f);
	}
	
//	public void updateFruit() {};
//	
//	public void deleteFruit() {};

}
