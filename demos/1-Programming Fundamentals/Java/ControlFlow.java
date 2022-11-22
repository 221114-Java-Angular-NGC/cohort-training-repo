
class ControlFlow{

	//Control Flow statement

	// Will affect the flow of how you code will be executed. 
	// Allows you to repeate blocks of code and ignore other code entirely. 
	// All based on the logice you've implemented 

	public static void main(String[] args){

	//For loops
	

	//For loops have 3 conditions 
	//for(<start>: <end> : <increment, or step by step>)	

/*
	for(int i = -27; i < 32; i = i + 3){

		//I want to start my for loop at i = -27, incremenet by adding 3, 
		// until i is greater than or equal to 32.

		System.out.println(i);

	}
*/


	int[] intArray = {32,45,67,23,12,123,54,23};
	// Typically used with data structures 

	

	for(int i = 0; i < intArray.length; i = i + 1){
		intArray[i] = intArray[i]/10;
		System.out.println(intArray[i]);
	}

	/*If and Else if 

		This control flow statment will conditionally execute a block of logic. 
		
		if(<conditional statement>){
			//block of code
		} 

				
		Here, the else if block will execute if the else if condition has been met and
		the "if" condition has failed.		

		if(<conditional statement>){
			//block of code
		} else if( <another conditional statement>){
			//block of code
		} else if( <another conditional statement>){
			//block of code
		}

		If no condition have been met, you can also a provide "else" logic. Which will only 	
		execute if none of the "if" or "else if" logics have been met. 

		
		if(<conditional statement>){
			//block of code
		} else if( <another conditional statement>){
			//block of code
		} else if( <another conditional statement>){
			//block of code
		} else {
			//block of code
		}
	*/

	/*
	if(true){
		System.out.println("This block of code will always execute");
	}
	
	if(false){
		System.out.println("This will never execute");
	}

	boolean boolValue = false;

	if(boolValue){
		System.out.println("This block of code will execute when boolValue is true");
	} else{
		System.out.println("boolValue is not true");
	}


	//numerical conditional logic 

	int a = 7;
	int a2 = 3;


	boolean b = (a > a2); //Conditional expressino will evaluate to a boolean 

	
		a == a2 
		a > a2
		a < a2 
		a => a2
		a =< a2 
		a =< (a2 + a2)

		!(a == a2) // ! flips the value of the conditional statement
	*/
	//System.out.println(b); 

	/*
	if(a > a2){
	
	}else if (a < a2){

	} else {
		System.out.println("a is equal to a2");
	}
	*/ 


	//While Loops
	//Do While 
	//Switch 
	// LEave that up to you guys to review 
	// Difference between if and else if and switch cases 

	}
}