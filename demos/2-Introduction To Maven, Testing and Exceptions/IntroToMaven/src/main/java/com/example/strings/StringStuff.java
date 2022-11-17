package com.example.strings;

public class StringStuff {
	
	/*
	 * String is an object that contains an array of characters. It allows you to 
	 * 	create and manipulate String literals. 
	 * 
	 * The String class is immutable and it is final.
	 * 	final: the class cannot be extended (i.e. can't have any child classes)
	 * 	immutable: the string itself can't be modified. 
	 */
	
	String exampleStringVariable;
	
	public void stringDemonstration() {
		
		//Instantiating a String in 2 ways
		
		String s = new String("The standard object way"); //don't do this. 
		
		//String literals is the text withing the speech marks
		String s2 = "Write it like this, a way better way."; 
		
		//The string is an object, as such it inherits all the Object methods.
//		System.out.println(s2.hashCode());
//		System.out.println(s2.toString());
//		System.out.println(s2.equals(s2));
//		
//		System.out.println(s2.length()); //the array has the property length, String has the method
//		System.out.println(s2.substring(0, 10));
//		System.out.println(s2.toUpperCase());
//		System.out.println(s2.charAt(0));
//		System.out.println(s2.split(" ")); //Will return an array, and the array toString method is simply its memory location
//		System.out.println(s2.trim());
		
		
		s = "Example String";
		String s3 = s;
		String s4 = s3;
		String s5 = s3;
		
		s = s.toUpperCase(); 
		//rather than modifiying the existing string, we create a brand new string literal in memory
		System.out.println(s);
		
		
		
		
	}

}
