package com.revature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaLists {
	
	/*
	 * List is one of the many subinterfaces of Collection. It is arguably one of the popular subinterfaces. The benefits of using a list include:
	 * 
	 * 1) unlike an array, a list is resizable
	 * 2) Implementation of List support random access (You can easily access an element using its index. 
	 * 3) List support duplicates.
	 */
	
	public static void main(String[] args) {
		
		/*
		 * Aside:
		 * 
		 * Generics allow us to impose compile-time safety on our datatypes as we use them. For instance, collection implementations use generics to ensure that the elements inside
		 * of the collection are all of a similar type. Note that only object types are supported
		 * with generics. This means that you cannot use a primitive type as your generic type;
		 * you should use a wrapper class representation instead.
		 * 
		 * ArrayList is a popular choice for a List implementation. It boasts:
		 * 
		 * 1) Fast random access
		 */
		
		//here, we have initialized a new arraylist that has a compile-time safety for this structure's type to be limited to just Integer values
		List<Integer> myList = new ArrayList<>();
		
		myList.add(1);
		myList.add(45);
		myList.add(101);
		
		//access an element from that list by its index
		System.out.println(myList.get(2));
		
		/*
		 * LinkedList is also a popular implementation of List, but not the same as an ArrayList.
		 * 
		 * For instance, Java cannot as quickly access a random element in a LinkedList because its elements are corelated with nodes
		 * */
		
		LinkedList<Integer> myLinkedList = new LinkedList<>();
		
		myLinkedList.add(2);
		myLinkedList.add(4);
		myLinkedList.add(6);
		
		System.out.println(myLinkedList.getFirst());
	}

}
