package com.revature.grading;

public interface GradingCalculator {
	
	//Return the percentage the student achieved. 
	double percentageOfCorrectAnswers(int correctAnswers, int incorrectAnswers);
	
	//Returning the grade. 
	String gradeAchieved(double percentageScore);

}
