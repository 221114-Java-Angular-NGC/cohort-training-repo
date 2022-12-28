package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Fruit;
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
	
	@PostMapping("/fruit")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void insertFruit(@RequestBody Fruit f) {
		fruip.save(f);
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE) //this method should rollback, if it can't complete its execution.
	// typically used in service layer methods, where you might utilise multiple repository/dao statements. 
	public void doStuff() {
		fruip.save(new Fruit(0, "Apple", 100));
		fruip.delete(new Fruit(0,"Kiwi",200));
	}

}
