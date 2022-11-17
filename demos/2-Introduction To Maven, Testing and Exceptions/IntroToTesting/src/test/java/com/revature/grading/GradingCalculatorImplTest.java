package com.revature.grading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradingCalculatorImplTest {
	
	/*
	 * Annotations provide meta data to the JVM
	 * In this case we provide @Test, so that the JVM sees this methods as a testing method. 
	 */
	
	GradingCalculator gradCalculator = new GradingCalculatorImpl();
	
	//the beforeAll and afterALL methods are invoked before the testing 
	// class is created and after the testing class has been terminated. 
	// static methods can be called without needing an instance, because it belongs to the class. 
	
	@BeforeAll
	public static void beforeEverything() {
		System.out.println("Before all");
	}
	
	@AfterAll 
	public static void afterEverything() {
		System.out.println("After all");
	}
	
	@BeforeEach
	public void beforeMethod() {
		System.out.println("This will print before every test!");
		//you can do anything, i.e. reset the class if it tracks state. 
	}
	
	@AfterEach
	public void afterMethod() {
		System.out.println("This will print out after every test!");
	}
	
	@Test
	public void TestStrings() {
		assertEquals("Hello","Hello");
		
//		assertEquals("Hello again", "Hello");
		//Make sure your tests are correct, if your tests are faulty then you're in for a bad time. 
	}
	
	
	@Test
	public void percentageOfCorrectAnswersTest(){
		
		//assertEquals(<expected result>, <actual result>)
		assertEquals(90.0, gradCalculator.percentageOfCorrectAnswers(9, 1));
		assertEquals(10.0, gradCalculator.percentageOfCorrectAnswers(1, 9));
		assertEquals(50.0, gradCalculator.percentageOfCorrectAnswers(5, 5));
		assertEquals(90.0, gradCalculator.percentageOfCorrectAnswers(900, 100));
		assertEquals(37.0, gradCalculator.percentageOfCorrectAnswers(37, 63),0.001); 
		//With decimal numbers, we can give a tolerance as a 3rd argument 
		//Tolerance says that the difference between the actual and the expected is smaller than the tolerance. 
		
		assertEquals(0.0, gradCalculator.percentageOfCorrectAnswers(0, 0));
		
		
		
	}
	
	@Test
	public void gradeAchievedTest() {
		
		assertEquals("A+", gradCalculator.gradeAchieved(90));
		assertEquals("A+", gradCalculator.gradeAchieved(100));
		assertEquals("A", gradCalculator.gradeAchieved(80));
		assertEquals("B", gradCalculator.gradeAchieved(70));
		assertEquals("C", gradCalculator.gradeAchieved(60));
		assertEquals("D", gradCalculator.gradeAchieved(50));
		assertEquals("E", gradCalculator.gradeAchieved(40));
		
		assertEquals("Not a grade", gradCalculator.gradeAchieved(105));
		assertEquals("Not a grade", gradCalculator.gradeAchieved(-15));
		
		assertNotEquals("A+", gradCalculator.gradeAchieved(89.99));
		

		
		
	}

}
