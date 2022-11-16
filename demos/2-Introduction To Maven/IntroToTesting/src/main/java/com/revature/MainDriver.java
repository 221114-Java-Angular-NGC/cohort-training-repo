package com.revature;

public class MainDriver {
	
	/*
	 * Testing in Software development: 
	 * Manual Testing 
	 * Automated Testing:
	 * 		Unit Testing 
	 * 		Integration Testing 
	 * 		Smoke testing
	 * 		... etc . 
	 * 
	 * Unit Testing: 
	 * 	Testing the smallest unit of code. A method, with methods we give sample inputs 
	 * 	and provide expected outputs. We compare then the actual results with predicted results. 
	 * 
	 * 	This allows us to verify our code works, in isolated small chunks. 
	 * 
	 * In Java we use JUnit - Unit Testing Framework. 
	 * 	
	 */

	public static void main(String[] args) {
	
		double correct = 1;
		double incorrect = 10;
		
		double percentage = (correct/(correct + incorrect))*100;
			System.out.println(percentage);
		
	}

}
