package com.revature;

import java.util.HashMap;
import java.util.Map;

/*
 * Technically speaking, Maps aren't a "Collection" in Java.
 * 
 * Technicalities aside, a Map allows you to store a group of related elements just like your
 * average Java Collection. Maps are notable for allowing you to store key-value pairs. They work
 * like a Dictionary (an obsolete type in Java) where in order to find a value, you must use its
 * specific key.
 */

public class JavaMaps {

	public static void main(String[] args) {
		//create a map
		/*
		 * HashMap is not thread-safe (to compare it with Hashtable). It does support the use of
		 * a null key. Note that a HashMap is backed by a Hashtable but this can change if need
		 * be - in which case it will be convered into a Tree.
		 */
		Map<Integer, String> dictionary = new HashMap<>();
		
		//add elememts to a map - use the put() method
		dictionary.put(1, "hat");
		dictionary.put(2, "cat");
		dictionary.put(3, "rat");
		dictionary.put(4, "tat");
		dictionary.put(5, "bat");

		
		//access an element from the map
		System.out.println(dictionary.get(3));
		
		//insert an element into map if element isn't already in the set
		dictionary.putIfAbsent(4, "Troy");
		
		System.out.println(dictionary);
	}

}
