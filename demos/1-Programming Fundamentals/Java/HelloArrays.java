

class HelloArrays{

	public static void main(String[] args){

		//Arrays: 
		// Are a structure that store variables/values of the same type 
		// In Java, arrays are immutable. The size of the array cannot be changed. 
		// Arrays in Java are also objects, we have some methods that all Java Objects will have. 
		// We also have one extra property - .length
	

		//To DECLARE an array: 
		//We DON'T declare size
		//int myArray[];
		int[] myArray; // Stick with this way of doing it 

		//Populating your array 

		//1) Directly populate it
		//char[] myCharArray = {'a','b','c'};

		//2) Create an empty array of fixed size
		char[] myCharArray = new char[3];
		myCharArray[0] = 'a'; //Arrays and all data structure in Java begin at 0
		myCharArray[1] = 'b';
		myCharArray[2] = 'c';

		myCharArray[0] = '2';

		
		myCharArray = new char[20]; //We are removing the old array and creating a brand new array. 

		System.out.println(myCharArray.length);
		System.out.println(myCharArray.toString()); //convert an object into a string expression
		(In the future, we are going to override this method to actually make it useful)

		
	}
}