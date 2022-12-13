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
 */

//Valid Javascript is valid TypeScript
console.log("Hello I'm in TypeScript");

let a = "This is a variable";

console.log(a);

//Typescript has support for static typing: 

let s1: number; //I've declared a variable "s1" to store number datatypes 

s1 = 12;
s1 = "Not a number!";

console.log(s1);