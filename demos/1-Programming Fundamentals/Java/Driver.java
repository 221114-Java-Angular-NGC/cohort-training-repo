class Driver{

	public static void main(String[] args){

	//Dog exists in the same folder/package 

	Dog goodBoy; //We can declare a variable that stores Dog types

	//Instantiate an object
	//We use the new keyword and the constructor in a class
	goodBoy = new Dog("Bob",20); 
	Dog stevey = new Dog("Stevey",30);

	new Dog();
	new Dog();
	new Dog();
	new Dog();

	//goodBoy.name = "Bob";
	//goodBoy.weight = 20;
	goodBoy.isGood = true;

	System.out.println(goodBoy);
	stevey.bark();
	goodBoy.bark();
	goodBoy.jump();


	

	System.out.println(goodBoy.toString());
	System.out.println(goodBoy.equals(stevey));
	


	//The Object class
	Object o = new Object();
	//Every object in Java is a "child" of the Object class
	// because of this relationship it inherits methods and 
	// attributes from the Object class

	//Some of these methods are: 
	// .equals(Object o) -> allowing us to compare objects 
	// .toString() -> this allows us to create a String expression
				to represent the object. 
	//	(Everytime you use the print method, the print method
		is calling the toString method - by default it's 
		calling the memory address of the object)
	// .hashCode() -> returns a unique number whish is a hash code


	//When writing Java code it's good to follow best practice when
	// it comes to upper case and lower case expressions. 

	//A variable should always be camelcase 

	double aBigNumber;
	boolean anotherBooleanValue;
	String thisIsAnotherString;
	Object myObject;

	Classes follow TitleCase. 

	Dog
	Animal
	SuperHero 

	Dog bobby;
	Animal kowala;
	SuperHero batman;

	Methods follow camelcase (similar to primitives)

	

	}
}