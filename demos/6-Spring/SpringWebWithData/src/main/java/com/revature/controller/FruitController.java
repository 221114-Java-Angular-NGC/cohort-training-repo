package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Fruit;
import com.revature.repo.FruitRepo;

@RestController //controller class
//@RequestMapping("/api")
public class FruitController {
	
	@Autowired
	FruitRepo fruip;
	

	
	@RequestMapping(method = RequestMethod.GET , value = "/fruits")
	public List<Fruit> getAllFruits(){
		return fruip.findAll();
	}

}
