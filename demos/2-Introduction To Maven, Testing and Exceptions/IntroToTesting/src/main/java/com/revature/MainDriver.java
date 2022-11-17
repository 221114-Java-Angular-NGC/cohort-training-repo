package com.revature;

import java.io.IOException;
import java.util.InputMismatchException;

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
	
	public static void riskyMethod() {
		throw new InputMismatchException("This is a fake exception");
	}
	
	public static void anotherExceptionMethod() throws IOException{
		throw new IOException(); //checked exception.
								//With checked exceptions we need to either handle it there and then 
								// or pass the problem to whoever is going to invoke this method.
		
//		try {
//			throw new IOException();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) {
	
		double correct = 1;
		double incorrect = 10;
		
		double percentage = (correct/(correct + incorrect))*100;
			System.out.println(percentage);
			
		
		
		//When an exception is thrown, no other logic will excecute (if it's not handled)
//		riskyMethod();
		
		
		//To handle an exception, we enclose the "risky" method within a try-catch block 
		//try catch 
		// try catch finally 
		// try finally 
			
		// try block will contain the "risky" code
		// the catch block will be the back up if something is thrown, depending on 
		// if the catch block is designed to handle the exception 
		// finally block will run regardless of antyhing being thrown. 
		
			
		try {
			
			//as soon as something goes wrong in the try catch block, the rest of the 
			// try block no longer excectues. 
			
			anotherExceptionMethod();
			riskyMethod();
			
		} catch(InputMismatchException e) {
			
			System.out.println("We could use this block to provide a safer method");
			System.out.println("or an alternative, if the original failed!");
			e.printStackTrace();
			
		} catch(IOException e) {
			
			System.out.println("This is a checked exception!");
			
//		} catch(Throwable t) { //this is a bad idea. You'll catch exception, but also errors. 
//			t.printStackTrace(); //there is no point in catching errors. !
//			
//		} 
//		} catch(Error e) { //this catch block will catch all other Exception object.
//			e.printStackTrace(); 
		} finally {
			
			System.out.println("Runs regardless of anything!");
		}
		
		
		
		
		try {
			throw new RuntimeException();
		}	
		catch(InputMismatchException e) { //InputMismatch is a child, so won't catch runtime
			e.printStackTrace();
		}catch(Exception e) {
			
			throw new ArrayIndexOutOfBoundsException();
			
		}finally {
			System.out.println("See if I can run!");
		}
		
		System.out.println("hello world!");
		
		try {} finally {
			
		}
		
	}

}
