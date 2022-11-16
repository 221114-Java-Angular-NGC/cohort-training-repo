package com.revature.grading;

public class GradingCalculatorImpl implements GradingCalculator{

	@Override
	public double percentageOfCorrectAnswers(int correctAnswers, int incorrectAnswers) {
		
		double percentage;
		
		if(correctAnswers == 0 && incorrectAnswers == 0) {
			percentage = 0;
		}else {
			double correct = correctAnswers;
			double incorrect = incorrectAnswers;
			
			percentage = (correct/(correct + incorrect))*100;
			
		}
		
		
	
		return percentage;
	}

	@Override
	public String gradeAchieved(double percentageScore) {
		
		return null;
	}

}
