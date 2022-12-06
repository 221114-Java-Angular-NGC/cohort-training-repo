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
 */

//if and else if 
if(false){
    var value = "inside block scope!";
    console.log(value);
}else if(true){
    var value = "another block";
    console.log(value);
}else{

}

//switch sttements 
//for loop 
//for each loop 
//while loop





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
function greetings(a,b){
    var num = 7;
    console.log(a + num + b);
    return 0;
}



