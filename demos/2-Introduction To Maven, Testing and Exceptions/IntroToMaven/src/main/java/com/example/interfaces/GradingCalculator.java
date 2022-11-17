package com.example.interfaces;

import com.example.exceptions.InvalidPercentageException;

public interface GradingCalculator {
	
	double pi = 3.14;
	double gravity = 9.81;
	
	//Return the percentage the student achieved. 
	double percentageOfCorrectAnswers(int correctAnswers, int incorrectAnswers);
	
	//Returning the grade. 
	String gradeAchieved(double percentageScore) throws InvalidPercentageException;

}
