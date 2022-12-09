/**
 * Object Oriented Programming in JavaScript. 
 * 
 * In Java we have the 4 pillars of OOP, Inheritance, Abstraction, Encapsulation and Polymorphism
 * 
 * In JS we have the 3 wooden posts of Obect Oriented coding, Inheritance, Encapsulation and Polymorphism.
 * 
 * I will be focusing on the differences between before Ecmascript 2015 and after.
 * 
 * 
 * Polymporhism: 
 *      In Javascript we don't get overloading or overriding concepts too much. 
 *      But we get optional parameters, so not every argument has to be passed in to invoke 
 *      a function. 
 *      With the use of default parameterts (setting a value in the method declaration) we can 
 *      ensure that some value is used, even if no arguments are passed through. This gives us 
 *      an aspect of Overloading from Java - we can vary the number of arguments. 
 * 
 * Inheritance: 
 *      Inheritance is achieved through prototypical inheritance (unlike class based inheritance in Java).
 *      Every object in JS has a "prototype", that will point to another object (e.g. it's "parent") or
 *      the Object object from the browser. 
 * 
 *      With ES6, we got class declarations that simplify the syntax so that it looks closer to 
 *      class based inheritance you find in Java or C#. But it's still prototype under the hood. 
 * 
 *      Prototype is simple reference to another object that contain common attributes and methods 
 *      which will save memory
 * 
 */

// A object in Javascript can be made without a class and follows JSON syntax. 
// Objects in JS are also dynamic, so properties can be added after the object is created. 

let obj = { key: "value",
            jump() {
                console.log("I'm jumping");
            },
            
};

//With properties in JS, we can use dot notation or bracket notation

// console.log(obj.key); //dot notation
// console.log(obj["key"]); //bracket notation 

// console.log(obj.name = "new name");

// obj.jump = "no longer a function";

// console.log(obj.jump);

// obj.jump();


//------------------Defining a Constructor-----------------------------


//Prior to ES6/ Ecmascript 2015
//We would declare a function to be used as a constructor - i.e. we use the "this" keyword 

function Robot(name, age = 0, mass = "0 pounds",jump = () => {}){
    this.name = name;
    this.age = age;
    this.mass = mass;
    this.jump = jump;
}

let ultron = new Robot("Ultron","3 days","220", () => {"I am jumping!"});
// console.log(ultron);

//age is a default parameter, so if none is provided then it will default to 0
let pinkRobot = new Robot("pink");
// console.log(pinkRobot);

//Post ES6 class 
// With ES6 we got class declarations as a feature 
// class Robot {
//     constructor(name, age, mass, jump) {
//         this.name = name;
//         this.age = age;
//         this.mass = mass;
//         this.jump = jump;
//     }
// }

//-----------------------INHERITANCE--------------------------------------

//Inheritance is achieved without classess
//With JS, every object has a prototype and we achieve inheritance through prototypical inhertiance. 

//Prior to ES6
let animal = {
    nickname: "bob",
    ability(){
        console.log("I have an ability");
        //returns nothing, so invoking it inside of a console.log() will return undefined. 
    }
}

console.log(animal);

let racoon = {name: "Racoon",__proto__: animal};

console.log(racoon);
console.log(racoon.name);
console.log(racoon.ability);
console.log(racoon.nickname);

class Animal{
    constructor(nickname){
        this.nickname = nickname;
    }

    ability(){

    }
}

class Racoon extends Animal {

}

//--------------------


