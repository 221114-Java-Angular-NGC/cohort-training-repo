
class ClassesAndObjects{

	/*
		Class is essentially a blueprint for the instantiation of an object. 
		Typically, if you want to access the methods and attributes of a class, 
		you'll need to make an instance of it. 

		Human have names. 
		"What is the name of human?"

		Bob is an instance of human 
		"What is the name of Bob?"
		
		In Java a class will have methods and attributes defined for instance of itself. 
	*/

	//Attributes - Every instance of "ClasseAndObjects" will have these 3 attributes: 
	int age;
	double weight; 
	String name;  

	//Methods 
	//A block of code that is executed when called upon. It consists of a method signature and body. 

	void jump(){}

	//Method signature will consist of method name, parameters, return type and access-modifiers
	void run(int distance){
		System.out.println("I'm running this far: " + distance);
	}

	double fly(){
		return 0;
	}

	public String myMethod(double d, int x, String s){
		System.out.println("");
		return s;
	}

		

}