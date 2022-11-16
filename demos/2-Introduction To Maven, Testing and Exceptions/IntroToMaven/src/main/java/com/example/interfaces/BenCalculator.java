package com.example.interfaces;

public class BenCalculator implements GradingCalculator{

	@Override
	public double percentageOfCorrectAnswers(int correctAnswers, int incorrectAnswers) {
		
		return 100;
	}

	@Override
	public String gradeAchieved(double percentageScore) {
		// TODO Auto-generated method stub
		return "A+";
	}

}
