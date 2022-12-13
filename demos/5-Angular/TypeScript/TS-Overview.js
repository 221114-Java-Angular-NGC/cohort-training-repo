/**This is TypeScript Comments! */
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
let s1; //I've declared a variable "s1" to store number datatypes 
//TS will throw an error when transpiling, but if valid JS will still convert into JS
s1 = 12;
// s1 = "Not a number!"; 
console.log(s1);
let s2; //implicitly declaring a variable to be of type "any"
let s3; //s2 and s3 are same datatype 
let s4;
s4 = 3;
s4 = "String";
s4 = true;
console.log(s4);
//In TS we can declare more data types than those that exist in JS
let n1 = null;
let n2 = null;
let n3 = undefined;
let n4 = null;
//----------------------Data Structures----------------------------
//Arrays 
let arr1; //a array of dynamic size that can store any datatype 
let arr2; //still mutable, but can't store anything other than numbers
let arr3;
arr1 = [1, 2, "string", true];
console.log(arr1);
//Tuples - immutable data structures
//fized size and datatypes have to be in a specific order 
let tuple1;
tuple1 = ['hello there', true, 1];
//Enum 
// A unique type that has a fixed set of values 
// An enumeration is a collection of constants, representational values 
//In JS way 
const OFF = 0;
const IDLE = 1;
const ACCEL = 2;
let myCarStatus = ACCEL;
if (myCarStatus == OFF) {
    //code executes if car state is off
}
//In TS way - enum values can only be a number
var carStates;
(function (carStates) {
    carStates[carStates["OFF"] = 0] = "OFF";
    carStates[carStates["IDLE"] = 1] = "IDLE";
    carStates[carStates["ACCEL"] = 2] = "ACCEL";
    carStates[carStates["CRUISING"] = -27] = "CRUISING";
})(carStates || (carStates = {}));
;
//defaults to 0,1,2,... etc. 
var otherStates;
(function (otherStates) {
    otherStates[otherStates["JUMPING"] = 0] = "JUMPING";
    otherStates[otherStates["HOPPING"] = 1] = "HOPPING";
    otherStates[otherStates["STOPPING"] = 2] = "STOPPING";
})(otherStates || (otherStates = {}));
;
if (myCarStatus == carStates.CRUISING) {
    //code executes if car state is cruising!
}
//------------------Functions-----------------------------------
function myFunc(a, b, c) {
    //basically JS code 
}
function myOtherFunc(a, b, c) {
    //make it more TS, with datatypes in our parameters
}
function finalFunc() {
    return "hi!";
}
let deimos = { name: "Deimos" };
let mars = {
    name: "Mars",
    hasRings: false,
    moons: [deimos],
    orbit: () => { console.log("I'm orbitting"); }
};
//------------------------Encapsulation----------------------
class Star {
    orbit() {
    }
    get Planets() {
        return this.planets;
    }
    set Planets(planets) {
        this.planets = planets;
    }
}
// In Typscript we also have "getters " and "setters"
// This time thought, they are explicitily given a label . 
//---------------------Polymorphism-----------------------------------------
//We don't have overloading in TS, but we do have optional parameters. 
// Giving us flexibility in how we utilize a method/constructor 
// A question mark will denote something has optional 
class Asteroid {
    constructor(name, nickname) {
        this.name = name;
        this.nickname = nickname;
    }
    crash() {
        console.log("Crashing into a planet!");
    }
    get Name() {
        console.log("I'm accessing a private variable through the getter method");
        return this.name;
    }
    set Name(name) {
        this.name = name;
    }
}
let asty = new Asteroid("asteroid-127", "asty");
let asty2 = new Asteroid("asteroid-128");
//getter
// console.log(asty.Name()); this is how we would do it in Java
console.log(asty.Name);
//Setter
// asty.set("new name");
asty.Name = "new Name";
console.log(asty.Name);
