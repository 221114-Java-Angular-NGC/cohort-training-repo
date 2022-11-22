import java.util.Scanner; //Import the scanner

class Driver{
	public static void main (String[] args){
	
	//Calculator c = new Calculator();

	System.out.println(args[0]);

	Scanner sc = new Scanner(System.in); //Creating Scanner

	System.out.println("Give us your name"); //Instruction for user

	String name = sc.nextLine(); //reading from the user

	System.out.println("Your name is " + name);

	System.out.println("Give us a number"); //Instruction for user

	int i = sc.nextInt();

	System.out.println("Your number multiplied by 10:");
	System.out.println(i*10);
	
	}
}