package com.revature;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainDriver {

	public static void main(String[] args) {
		//Technically, Maps are not a collection, but is a essential data structure in Java that can be used to implement key-value pairs
		//Maps do not guarantee order or allow for duplications.
		
		//creating a hashmap
		HashMap<String, Integer> shoppingCart = new HashMap<>();
		
		//add some items to my cart
		//use the map's put() method to insert new elements
		shoppingCart.put("Tomatoes", 7);
		shoppingCart.put("Potatoes", 5);
		shoppingCart.put("Vegatable Oil", 3);
		shoppingCart.put("Onions", 12);
		
		//get the values of a given key from my map
		//get() used here
		System.out.println("The price for onions is " + shoppingCart.get("Onions"));
		
		//check if hashmap is empty
		System.out.println("Is map empty: " + shoppingCart.isEmpty());
		
		//remove elements
		shoppingCart.remove("Onions");
		
		//show the contents of the map
		System.out.println("Shopping items: \n" + shoppingCart);
		System.out.println("Size: " + shoppingCart.size());
		
		//iterating thru the map
		//this iterator will contain a cursor that will point to each element in our map and then move to the point by the next() method
		Iterator<Map.Entry<String, Integer>> iterator = shoppingCart.entrySet().iterator();
		
		while(iterator.hasNext()) {
			//select the current element
			Map.Entry<String, Integer> item = iterator.next();
			
			//print to console
			System.out.println("Key= " + item.getKey() + ", Value= " + item.getValue());
		}
		
		

	}

}
