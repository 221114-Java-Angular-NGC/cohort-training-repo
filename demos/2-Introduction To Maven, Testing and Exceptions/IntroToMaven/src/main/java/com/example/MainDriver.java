package com.example;

import java.util.Scanner;

import com.example.interfaces.BenCalculator;
import com.example.interfaces.BenTruck;
import com.example.interfaces.BetterTruck;
import com.example.interfaces.Car;
import com.example.interfaces.GradingCalculator;
import com.example.interfaces.Truck;
import com.example.strings.StringStuff;

public class MainDriver {
	
	public static void main(String[] args) {
		
//		System.out.println("Hello!");
		
		StringStuff sStuff = new StringStuff();
		sStuff.stringDemonstration();
		
		
		Truck t = new BenTruck(); //This won't work, because interfaces don't have constructors. 
		t = new BetterTruck();
		
		//because BetterTruck is a child of Car and Truck, it can act as both.
		Car c = new BetterTruck();  
		
//		t.pickUpStuff();
//		t.accelerate();
//		t.brake();
//		
//		c.accelerate();
//		c.pickUpStuff();
//		c.brake();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What were the correct answers?");
		int correct = sc.nextInt();
		
		System.out.println("What were the incorrect answers");
		int incorrect = sc.nextInt();
		
		GradingCalculator gc = new BenCalculator();
		
		double percentage = gc.percentageOfCorrectAnswers(correct, incorrect);
		
		System.out.println("The percentage they got is: " + percentage);
		
		System.out.println("And the grade they achieved is: " + gc.gradeAchieved(percentage));
		

		
	}

}
