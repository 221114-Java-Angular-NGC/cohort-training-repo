package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Fruit;
import com.revature.service.FruitService;

@RestController
public class FruitController {

	@Autowired
	private FruitService fruitService;
	
	@GetMapping("/consumer/fruits")
	public List<Fruit> getAllFruits(){
		return fruitService.getFruitList();
	}
}
