package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Fruit;

@Service
public class FruitService {
	
	private List<Fruit> fruitList = new ArrayList<>();


	public List<Fruit> getallFruits() {
		// TODO Auto-generated method stub
		
		
//		fruitList.add(new Fruit(0,"Apple",50));
		return fruitList;
	}

	public Fruit getSingleFruit() {
		// TODO Auto-generated method stub
		return new Fruit(0,"Kiwi",50);
	}

	public Fruit getFruitById(int id) {
		
		return new Fruit(id,"Kiwi",50);
	}

	public void createFruit(Fruit incomingFruit) {


		fruitList.add(incomingFruit);
		
	}

}
