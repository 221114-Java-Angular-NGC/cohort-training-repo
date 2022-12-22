package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Fruit;
import com.revature.service.FruitService;

@RestController //This controller is expected to send back json - not any views 
//by default, all methods effectively have a @ResponseBody appended to their return values.
@RequestMapping(value="/another/api")
public class RestfulFruitController {
	
	@Autowired
	private FruitService fruitService;
	
	@GetMapping(value="/fruits", produces="application/json")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public List<Fruit> getAllFruits(){ //because this is a controller, we need to specify that this is going to be a json 
										// that is going to be sent back as a payload in the body. 
		return fruitService.getallFruits();
	}

}
