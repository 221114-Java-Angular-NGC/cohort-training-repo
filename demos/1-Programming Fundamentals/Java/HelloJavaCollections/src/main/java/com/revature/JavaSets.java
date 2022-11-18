package com.revature;

import java.util.HashSet;
import java.util.Set;

public class JavaSets {

	/*
	 * Set is another subinterface of Collection. Set is often contrasted with List as many of
	 * the operations a list supports a set does not:
	 * 
	 * 1) Sets do not support random access.
	 * 2) A Set does not support duplicates.
	 * 3) A Set does not guarantee that the order of insertion will be preserve
	 */
	public static void main(String[] args) {
		//create a new set of strings
		Set<String> seatChart = new HashSet<>();
		
		//adding elements to the set
		seatChart.add("Bob");
		seatChart.add("Tom");
		seatChart.add("Herb");
		seatChart.add("Harry");
		seatChart.add("Sue");
		
		//check if this set contains a specific element
		System.out.println(seatChart.contains("Rob"));
		
		//remove an element from a set
		seatChart.remove("Hort");
		
		//print all contents of my set -- iterate through our set
		//1. using an Iterator - special utility class that allows for 
		//java to iterate throug any Collection interface that is Iterable (functional interface)
		
		//2. for-each loop
		for(String name : seatChart) {
			System.out.println(name);
		}
		//There are several other implementations of the Set interface:
		//HashSet, TreeSet, LinkedHashSet

	}

}
