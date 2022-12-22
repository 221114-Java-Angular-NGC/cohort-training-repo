package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.models.Fruit;
import com.revature.service.FruitService;

@Controller
@RequestMapping(value="/api")
public class FruitController {
	
	@Autowired
	private FruitService fruitService;
	
//	@RequestMapping(value = "/fruits", method = RequestMethod.GET)
	@GetMapping(value="/fruits", produces="application/json")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public @ResponseBody List<Fruit> getAllFruits(){ //because this is a controller, we need to specify that this is going to be a json 
										// that is going to be sent back as a payload in the body. 
		return fruitService.getallFruits();
	}
	
	@GetMapping(value="/responseEntity/fruits")
	public ResponseEntity<List<Fruit>> getAllFruitsAgain(){
		return new ResponseEntity<List<Fruit>>(fruitService.getallFruits(),HttpStatus.ACCEPTED); //
	}

	
	@GetMapping(value="/fruit/{id}") //localhost:<port>/fruit/<id>
	public @ResponseBody Fruit getFruitById( @PathVariable("id") int id) {
		return fruitService.getFruitById(id);
	}
	
	@GetMapping(value="/fruit", params= {"id"}) //localhost:<port>/fruit?id=<value>
	public @ResponseBody Fruit getFruitByParam(int id) {
		return fruitService.getFruitById(id);
	}
	
	
	@PostMapping(value="/fruit", consumes="application/json")
	public @ResponseBody String createFruit(@RequestBody Fruit incomingFruit) {
		
		fruitService.createFruit(incomingFruit);
		
		return "Success";
	}
	
	
}
