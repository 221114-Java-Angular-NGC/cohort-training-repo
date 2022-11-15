//This is a comment in Java!!!
//The Java compiler will ignore these line and the one above
// This is where we would provide notes for other developers. 

//A Java class cannot consist of just comments 

//Important to make sure the file name matches the class name. 
class HelloWorld {
	
	//console.log("Hello World")
	//print("Hello World")

	 

	//We need to tell Java when to start executing the logic. 
	//The main method in Java: 

	public static void main(String[] args){

		//printing hello world in Java
		System.out.println("Hello World");



	//Java Primitive Types
	//Primitive types vs Objects vs Reference types
	// Primitve types are very simple variables, that only store a single value. 
	// In Java we have 8 of them, with varying sizes. 
	
	/*
	Primitives can be distinguished by what they store and their memory capacity. 
	boolean 	JVM dependent (can be a bit or 8 bits)	true or false values
	byte 		8 bits 		numerical integer values 
	short 		16 bit		numerical integer values 
	char  		16 bit 		numerical values/Unicode character
	int 		32 bit		numerical integer values
	long 		64 bit		used to store larger integer values
	double 		64 bit		decimal values
	float 		32 bit		decimal values 
	*/


	//create these variables in Java

	//Declaring
	int i; //This will create a "i" variable that will be able to store data types of int.
		//x cannot store double data types. 

	//Assignment 
	i = 10;
	
	//Reassignment
	i= 7; //we can change the value of x, but not the data type that it can store 

	System.out.println(i); 
	
	
	double d = 27.3;

	System.out.println(d);

	boolean b = true;
	byte bt = 7;

	System.out.println(bt);

	char c = 'a'; //With char, we use a single quotes and provide a single expression
	c = '%';
	c = 550; //char will interpret the integer value as a character
	c = '5';
	c = 5; //theser are different, 5 will map to a unicode value and '5' is a expression 5

	//c = 'abc'; //this is too long for char c to store
	
	System.out.println(c);

	float f1 = 37;
	float f2 = 25;
	float f3 = f1 + f2;

	double d1 = f3 + f2 + f1;

	double d2 = i;

	int i1 = d2;

	System.out.println(f3);
	System.out.println(d1);


	}	
}
