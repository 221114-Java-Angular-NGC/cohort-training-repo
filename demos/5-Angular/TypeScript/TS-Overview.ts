/**This is TypeScript Comments! */

import { Car } from './Car';
import { Truck } from './Truck'

/**
 * TypeScript for Java Developers: https://www.typescriptlang.org/docs/handbook/typescript-in-5-minutes-oop.html
 * 
 * What is TypeScript?
 *      TypeScript is a OOP language with static typing that is a syntatically superset of JavaScript. 
 *      It is free and open source and supported by Microsoft. 
 * 
 *      TS was developed for larger applications, it provides features that help make debugging and 
 *      building robust applications easier (syntax is closer to Java and C#).
 * 
 * To install (also require node and npm): 
 *      npm install -g typescript
 * 
 * Browsers can't natively run TypeScript files. Instead we need to "transpile" typescript code into 
 *  javascript code. 
 * 
 * Transpiling vs Compiling?
 *  Transpiling is where a language is converted into another similar level of abstraction language. 
 * 
 * To transpile: 
 *      1) Open up the terminal 
 *      2) Execute: "tsc *filename*.ts"
 * 
        Sometimes TypeScript can't compile new features into legacy JavaScript code, so we can 
            ask it to transpile into a newer version 

        2) tsc -t es2015 *filename*.ts
 * 
 */

//Valid Javascript is valid TypeScript
console.log("Hello I'm in TypeScript");

let a = "This is a variable";

console.log(a);


//-----------------------------Static Typing-------------------------------------------

//Typescript has support for static typing: 

let s1: number; //I've declared a variable "s1" to store number datatypes 

//TS will throw an error when transpiling, but if valid JS will still convert into JS
s1 = 12;
// s1 = "Not a number!"; 

console.log(s1);

let s2; //implicitly declaring a variable to be of type "any"
let s3: any; //s2 and s3 are same datatype 
let s4: number|string|boolean;

s4 = 3;
s4 = "String";
s4 = true;

console.log(s4);

//In TS we can declare more data types than those that exist in JS

let n1: null = null;
let n2: void = null;
let n3: null = undefined; 
let n4: undefined = null;

//-------------------------------Data Structures----------------------------

//---Arrays---
let arr1: any[]; //a array of dynamic size that can store any datatype 
let arr2: number[]; //still mutable, but can't store anything other than numbers
let arr3: Array<boolean>;

arr1 = [1,2,"string",true];

console.log(arr1);

//---Tuples--- 
//immutable data structures
//fized size and datatypes have to be in a specific order 
let tuple1: [string,boolean,number];
tuple1 = ['hello there',true,1];

//----Enum----
// enum: https://www.typescriptlang.org/docs/handbook/enums.html#string-enums
// A unique type that has a fixed set of values 
// An enumeration is a collection of constants, representational values 

//In JS way 

const OFF = 0;
const IDLE = 1;
const ACCEL = 2;

let myCarStatus = ACCEL;

if(myCarStatus == OFF){
    //code executes if car state is off
}

//In TS way - enum values can only be a number
enum carStates {OFF = 0, IDLE = 1, ACCEL = 2, CRUISING=-27};

//defaults to 0,1,2,... etc. 
//We can also add string enums but you cannot use strings and numbers at the same time.
enum otherStates {JUMPING="JUMP",STANDING="STAND"};

if(myCarStatus == carStates.CRUISING){
    //code executes if car state is cruising!
}

//----------------Object---------------------------------

//https://stackoverflow.com/questions/49464634/difference-between-object-and-object-in-typescript
// The above link is a stack overflow, but it's the most succinct source I've seen so far.

let myObj: Object|object|{}; //different ways to declare a type of object.

//------------------Functions-----------------------------------

function myFunc(a,b,c){
    //basically JS code 
}

function myOtherFunc(a: number,b:string,c:boolean|Array<null>){
    //make it more TS, with datatypes in our parameters
}

function finalFunc(): string|void{
    return "hi!";
}

//----------------OOP in TS---------------------------------------
// Abstraction, Inheritance, Polymorphism, Encapsulation 

//------------------------Abstraction------------------------------------ 
/**
 * NOTE: We do get Abstract Classes in TS, they behave similarly to Abstract Classes in Java 
 * 
 * In TypeScript we get Interfaces and Abstract Classess.
 * 
 * Interfaces:
 *     Both properties and methods can be declared to be required by child classes
 *     Properties are implicitly "public" and can't be modified to "protected" or "private" levels of access
 *     Classes can implement multiple interfaces
 *      
 * Abstract Classes: 
 *      Can define abstract methods inside of class - using "abstract" keyword, but not required. 
 *      Constructors can be declared inside 
 *      Cannot extend multiple Abstract classes
 * 
 * Java vs TypeScript: 
 *      Unlike in Java, we can instantiate interfaces directly without needing to declare a child class to implement it. 
 *      
 */
interface Moon {
    name: string
}

interface Planet{
    name: string, 
    hasRings: boolean,
    moons: Array<Moon>,
    orbit(): void
}

//Classes can implement multiple interfaces 
//Interfaces can also extend multiple other interfaces

interface A{};
interface B{};
interface C extends A,B{}
interface D{}

abstract class E implements C,D {};
class F extends E{};

//Abstract Class 
abstract class absClass{
    name: string;
    constructor(name: string){this.name = name}
    public abstract abstractMethod();
}

//Instatiating interface datatypes directly. 
let deimos: Moon = {name:"Deimos"};

let mars: Planet = {
    name: "Mars",
    hasRings: false,
    moons: [deimos],
    orbit: () =>{console.log("I'm orbitting")}
}

//------------------------Encapsulation----------------------
/**
 * Typescript has support for access modifiers and Setter and Getter methods 
 * 
 * Access Modifers: 
 *     private, protected and public 
 * 
 * Getters and Setters: 
 *      Are created with using "set" and "get" keywords
 *      Method invokation is syntaxially similar to refering to them as properties. 
 *      e.g. instead of "obj.setName(newName)" we do "obj.Name = newName"
 *          
 * NOTE: When transpiling, remember to transpile to es2015 "tsc -t es2015 <file>.ts"
 *          JS does not have support for getters and setters before es2015.
 */

class Star {

    private name: string;
    protected mass: number;
    public numberOfPlanets: number;

    constructor(name: string, mass: number, numberOfPlanets: number){
        this.name = name;
        this.mass = mass;
        this.numberOfPlanets = numberOfPlanets;
    }

    get Name(): string {
        return this.name;
    }

    set Name(name: string){
        this.name = name;
    }

    get NumberOfPlanets(): number {
        return this.NumberOfPlanets;
    }

}

let theSun: Star = new Star("The Sun",1,8);
let bigSun: Star = new Star("Alpha A",10,4);

//Getter
// console.log(asty.Name()); this is how we would do it in Java
console.log(theSun.Name);


//Setter
// asty.set("new name"); How we would do it in Java
theSun.Name = "new Name";
console.log(theSun.Name);

//------------------Inheritance--------------------------------
/**
 * TypeScript also support for Class based inheritance, using the Extends keyword
 * 
 * Child Classes will inherit methods and properties from their parent classes.
 * Like Java, we can only extend a single class at a time but you can have multilevel inheritance. 
 * 
 * Constructors are implictly inherited from parent class. If no constructor is declared in the 
 *  child class then the parent class constructor will be used. 
 * If a constructor is declared, then you have to explicitly use the "super" keyword to call the 
 *  parent constructor. 
 * 
 */

class Asteroid{

    private name: string;
    private nickname: string;

    constructor(name: string, nickname?: string){
        this.name = name;
        this.nickname = nickname;
    }

    crash(): void{
        console.log("Crashing into a planet!")
    }

    get Name(): string{
        console.log("I'm accessing a private variable through the getter method")
        return this.name;
    }

    set Name(name: string){
        this.name = name; 
    }
}

class Meteor extends Asteroid{};

let met1: Meteor = new Meteor("meteor-12","big one"); //using parent contructor 
met1.Name = "new name"; //using parent setters
console.log(met1.Name); //using parent getter
met1.crash(); //parent crash() method

//---------------------Polymorphism-----------------------------------------
/**
 *  Overriding:
 *      Child classes can modify the behaviors the inherit from their parent class. 
 *      Method signature has to match, you can't add arguments and the level of access 
 *          have to be the same or greater. 
 * 
 *  
 *  Overloading: 
 *      Unlike Java, we don't decalare multiple methods with different parameters. 
 *      Instead we use optional parameters, these are denoted by "?"
 *      (Optional parameters have to be on the right hand side or required parameters)
 *  
 * 
 */

class Meteorite extends Asteroid{

    
//When we declare an access modifier in the parameter, we're effectively declaring it as 
// a member of the class. 

    constructor(name: string, nickname: string, private size?: number){
        super(name,nickname);
        this.size = size;
    }

    crash(): void{
        super.crash(); //still utilize our parent function
        console.log("Crashing into a planet with a very BIG BOOM!");

    }

}
//When a constructor isn't provided, it'll default to parent constructor
let bigDino: Meteorite = new Meteorite("Meteorite-123","The Big One"); 

bigDino.crash();
console.log(bigDino.Name);



//-----------------------------------------------------------------------------------------
//--------------------------Using Imported Classes----------------------------------------

let aston:Car = new Car("Bobby",0);

let toyota:Truck = {
    name: "My Truck",
    capacity: 100
}