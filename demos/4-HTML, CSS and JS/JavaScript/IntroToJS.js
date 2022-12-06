console.log("Hello JS!")


/**
 * This is a comment in JS
 */

//This is also a single line comment in JS

/**
 * 
 * What is Javascript?
 * 
 *      Not at all related to Java
 *      Scripting language, unlike Java which a compiled programming language
 *      Used to design and manipulate webpages - runs on the browser.
 * 
 *      Created in 1995 by Brandan Eich (10 days)
 * 
 *      JS is a loosely typed, interpreted, object-based, scripting language*.
 *      Used to design and manipulate webpages - to provide more interactivity/functionality. 
 * 
 *      Benefits?
 *          Less server interaction
 *          Increased interactivity
 *          ASI (Automatic Semicolon insertion)
 */

/**
 * 
 * What is ES6?
 *  Scripting lnaguages follow a standard set by an organization called ECMAS.
 *  Javascript being a scripting languagle follow these standards. 
 *  ES6 was a standard introduced in 2015, EcmaScript 2015. Which introduced new features and datatypes
 *      for developers. 
 *  ECMA is an international body that sets the standard for all scripting language. 
 * 
 *      let and const
 *      class declarations
 *      fat arrow notation 
 *      template literals
 * 
 */

/**
 * VAriable declarations
 * 
 * var vs let vs const
 * 
 * let and const have support for gloabl, local/function and block/loop scopes.
 * var have support for global and local, but not block scope. 
 * 
 * Global: accessible anywhere in the script
 * Local: accessible anywhere within a function or object
 * Block: within control flow statements. 
 *  
 * 
 * Variables don't declare a datatype (loosely typed)
 * 
 * Variables also get hoisted to the top of their scope, but only the declaration. Not any assignments.
 * This is only supported for var variables. Let and const variables actively throw an error (but they 
 * still get hoisted)
 */


//In JS, we don't need to declare datatype when we declare a variable 
//In JS we have 3 keywords to declare a variable. 

//var is the old way of doing it.
// var does not support block scope.
var num = "A number";
// num = 12; 
// num = true;

//let, let is the newer way and better recommended way 
// It provides support for global, function and block scopes. 
let num2 = num; 
num2 = 11;
num2 = false;

let num3;

//const, is also a newer keyword for declaring "final" variables in JS
const pi = 3.14;

/**
 * Datatypes in JS?
 * 
 * primtive datatypes:
 * number 
 * undefined
 * null
 * string
 * boolean 
 * 
 * non-primitive datatypes: 
 * objects
 * arrays
 * function
 * 
 * bigint - ES10
 * symbol (unique and immuitable primitive value) - ES6
 */



/**
 * Control flow statements
 * 
 * In JS we get a lot of the same control flow statements has Java
 *  if and else 
 *  switch sttements 
 *  for loop 
 *  for of loop 
 *  for in loop
 *  while loop
 */

//if and else if 
// if(false){
//     var value = "inside block scope!";
//     console.log(value);
// }else if(true){
//     var value = "another block";
//     console.log(value);
// }else{

// }


/**
 *  Arrays
 * 
 *  In JS we can declare arrays like variables
 *  An array in JS is mutable in size and they don't need to contain the same datatypes
 * 
 * Arrays can store "itself" in its elements
 * If a position is selected to be added to outside the size of the array, 
 *      it will simply add empty elements inbetween
 */

let arrayOfPlanets;
arrayOfPlanets = []; //assigned to an empty array
arrayOfPlanets = ["Mercury","Venus","Earth"];
arrayOfPlanets = ["Mercury","Venus","Earth",2,true,undefined];
arrayOfPlanets = ["Mercury","Venus","Earth",2,true,undefined,["Tomatoes","Apple","Banana"]];
arrayOfPlanets = ["Mercury","Venus","Earth",2,true,undefined,["Tomatoes","Apple","Banana"],arrayOfPlanets];


// console.log(arrayOfPlanets);
// console.log(arrayOfPlanets[0]);
// arrayOfPlanets[2] = "Mars";
// arrayOfPlanets[11] = "Pluto";
// console.log(arrayOfPlanets);

// for(let i of arrayOfPlanets){
//     console.log(i);
// }

/**
 * Objects in JS
 * 
 * In JS, we don't need classes to create an object
 * Unlike in Java, objects aren't class based and don't inherit through classes 
 *  (instread through prototypical inheritance)
 * 
 * Creating an object in java is similar to a primitive data type
 * 
 * Objects are dynamic in JS, they can be modfied during runtime
 */

let myObject; //declare a variable 
myObject = {}; //we use curly braces to denote an "object literal"
myObject = {
    "key": "value"
};

let planet = {
    name: "Earth",
    "distance": 1,
    humans: true,
    orbit: function(){
        console.log("Look at me, I'm orbiting!")
    }
};

planet.weather = "Quite lovely!";


// console.log(planet);
// planet.orbit(); //function is stand alone, a method is a function associated to an object. 

/**
 * Functions
 * 
 * Functions are "hoisted" to the top of its scope in the script whenever the browser starts interpreting the code. 
 * For the functions, the declaration and the body are moved to the top so that they can be utilised
 * whenever. (This is automatic and you don't need do anything as a developer.)
 */

//  greetings(10,12);
//  greetings("a",true);
//  greetings(true,"a");
//  greetings(true,false);

//declare a function:

// dontReturnStuff(12,"this shouldn't work!");
// greetings(1);

function doStuff(){};

function dontReturnStuff(){
    console.log("Just printing, not returning!");
}

function greetings(a,b){
    var num = 7;
    console.log(a + num + b);
    return 0;
}

//--------------------------Anonymous functions------------------------
// Theser are functions, that aren't declared. Instead are stored in variables 

let anon = function(a,b){
    return a*b;
}

console.log(anon);
console.log(anon(1,2));

anon = 2;

// console.log(anon(1,2)); //this will throw an error, cause I've replaced the function with a number

//----------------------------Callback function-------------------
// A function that is passed as a parameter into another function

function inceptionFunction(myFunc){
    console.log("I'm in the parent function")
    myFunc(); // We're invoking a function inside of the function

    doStuff(); //THIS IS NOT A CALLBACK FUNCTION
}

let a1 = function(){
    console.log("callback function 1");
}

let a2 = function(){
    console.log("another callback function");
}

// inceptionFunction(a1);
// inceptionFunction(a2);

// ---------------------(ES6) Fat Arrow Notation------------------------
// Short hand expression for writing out functions 
let arrow = (x,y) => {return x*y};

let sayHello = name => {
    console.log(name + " says hello");
}

// --------------------Self invoking functions --------------------------
// These are functions that call themselves straightaway 
// IIFE - Immediately Invokable Funciton expressions 

// let fun1 = function(){
//     console.log("Inside IIFE");
// }();


/**
 * Truthy and Falsey values 
 * 
 * Everything has a true or false boolean value when used in a conditional statment
 * 
 * Example of falsey value is: 0 (every other number is truthy)
 *                              ""
 *                              undefined
 * Let you all discover the rest!
 */


let k;
k = 0; //not truthy 
k = -123;
k = "";
k = undefined;

if(k){
    console.log(k + " is truthy!");
}else{
    console.log(k + " is not truthy");
}

/**
 * Comparison operators
 * 
 * == 
 * ===
 * !=
 * >
 * >=
 * <
 * <=
 */

let b1 = 2;
let b2 = "2";

// console.log(b1 == b2); // "==" will automatically convert the datatypes into the same type. (type coercion)
// console.log(b1 === b2); //check the type and the value (no type coercion)

// console.log(1 == true); // will return true
// console.log("" == 0); //will return true


/**
 * Checking the type and NaN
 */

// console.log(typeof(b1));
// console.log(typeof(b2));
// console.log(typeof({}));
// console.log(typeof([])); //arrays are objects as well 
// console.log(typeof(() => {}));


//Sometimes we want to do a mathematical operations, we want to check if it's a number

// console.log(isNaN(2)); // 2 is a number, so isNaN will return false;
// console.log(isNaN("2")); // isNaN will also do automatic type coercion and check the value - also false
// console.log(isNaN("two")); //this can't be converted to a number by the browser, so it is true. 

// console.log(1/0);
// console.log(isNaN(Infinity)); // Infinity is a number!? 
// console.log(0*Infinity); // NaN will be returned because this is considered an invalid operations
// console.log(Infinity/Infinity);

// console.log(typeof(NaN)); //Not a Number is consdered a number datatype


/**
 * ES6 Template Literal Strings
 * Much easier to create and format strings. 
 */

let namePerson = "Bob";
console.log(namePerson + " says" + "\n hello!");

console.log(`

        ${namePerson}
                        says
                                    Hello!
`);