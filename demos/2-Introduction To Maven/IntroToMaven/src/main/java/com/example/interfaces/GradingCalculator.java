package com.example.interfaces;

public interface GradingCalculator {
	
	double pi = 3.14;
	double gravity = 9.81;
	
	//Return the percentage the student achieved. 
	double percentageOfCorrectAnswers(int correctAnswers, int incorrectAnswers);
	
	//Returning the grade. 
	String gradeAchieved(double percentageScore);

}
