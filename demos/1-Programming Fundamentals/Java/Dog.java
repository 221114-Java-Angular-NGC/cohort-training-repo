
public class Dog{

	//I don't have any written constructors. 
	// In Java, if you don't provide a constructor a default constructor 
	//	will be provided. 

	//Constructors: 
	/*
	A consturctor is a special method that is used to instantiate an object, 
	it does not have a return rype. 
	A constructor is always called when an object is created, it's inovked with
	the "new" keyword 

	(implicit) Default constructor: 
	The JVM will always provide a constructor if none have been provided. It's 
	provided udring compile time. 

	Other than creating it in memory, it does nothing else. Effectively it is 
	a no args constructor with no body. 

	No-args construcotr: 
	It's developer created and allows us to do things
	*/ 

	//Constructor will have no return type
	//Will have the same name as the class
	public Dog(){
		System.out.println("I'm being created!!!");
		//We can provide some default values 

		this.name = "placeholder";
		this.weight = 0;
		this.isGood = true;
	}
	
	//parametrized constructors 
	public Dog(String dogName, double dogWeight){

		this.name = dogName;
		this.weight = dogWeight;
		this.isGood = true;
	}
	
	String name;
	double weight; 
	boolean isGood;

	void jump(){
		System.out.println("I'm jumping");
	}

	void bark(){
		System.out.println("I'm " + this.name);
	}

}