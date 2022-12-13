/**This is TypeScript Comments! */

import { Car } from './Car';
import { Truck } from './Truck'

/**
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
 * Browsers can't naitevly run TypeScript files. Instead we need to "transpile" typescript code into 
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

//----------------------Data Structures----------------------------

//Arrays 
let arr1: any[]; //a array of dynamic size that can store any datatype 
let arr2: number[]; //still mutable, but can't store anything other than numbers
let arr3: Array<boolean>;

arr1 = [1,2,"string",true];

console.log(arr1);

//Tuples - immutable data structures
//fized size and datatypes have to be in a specific order 
let tuple1: [string,boolean,number];
tuple1 = ['hello there',true,1];

//Enum 
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
enum otherStates {JUMPING, HOPPING, STOPPING};

if(myCarStatus == carStates.CRUISING){
    //code executes if car state is cruising!
}

//----------------Object ---------------------------------

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

//Abstraction 
// In Java, Abstraction is achieved using Interfaces and Abstract Classes
// We do get interfaces in TS 

//In TS, interfaces are property driven rather than behavior driven. 
interface Moon {
    name: string
}

interface Planet{
    name: string, 
    hasRings: boolean,
    moons: Array<Moon>,
    orbit(): void
}

let deimos: Moon = {name:"Deimos"};

let mars: Planet|Moon = {
    name: "Mars",
    hasRings: false,
    moons: [deimos],
    orbit: () =>{console.log("I'm orbitting")}
}

//------------------------Encapsulation----------------------

class Star implements Moon, Planet{
    // We now have access to access modifiers,
    // private, public and protected 
    // (no more closure for us!)

    public name: string; //this is accessible anywhere 
    hasRings: boolean; //default to public 
    
    protected nickname: string; //accessible internally to the class or any child classes

    private planets: number; //only accessible internally 

    public moons: Array<Moon>;

    public orbit(): void { //can also have access modifiers with functions/methods

    }

    get Planets(): number{
        return this.planets;
    }

    set Planets(planets: number){
        this.planets = planets;
    }
}


// In Typscript we also have "getters " and "setters"
// This time thought, they are explicitily given a label . 




//---------------------Polymorphism-----------------------------------------
//We don't have overloading in TS, but we do have optional parameters. 
// Giving us flexibility in how we utilize a method/constructor 
// A question mark will denote something has optional 

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

let asty: Asteroid = new Asteroid("asteroid-127","asty");
let asty2: Asteroid = new Asteroid("asteroid-128");

//getter
// console.log(asty.Name()); this is how we would do it in Java
console.log(asty.Name);


//Setter
// asty.set("new name");
asty.Name = "new Name";

console.log(asty.Name);

//------------------Inheritanc--------------------------------
//When overriding a method, you can't provide more arguments but you take them away.
//Methods cannot be more restrictive. 

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


//from out other file 
let aston:Car = new Car("Bobby",0);

let toyota:Truck = {
    name: "My Truck",
    capacity: 100
}