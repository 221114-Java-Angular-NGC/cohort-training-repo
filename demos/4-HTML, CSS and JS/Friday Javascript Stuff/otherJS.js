
//--------------------Strict Mode ------------------------------------------
//In JS , we can use strict mode to make sure we follow good coding practices. 
// e.g. not using undefined variables 
//" strict mode" can be used inside of a function or within the whole script

// "use strict";

function fastAndLoose(){

    "use strict";

    //In JS, everythign is forgiving. 
    //So currently I'm able to use a variable without every declaring it. 
    y = 42; //This will throw an error, as the variable is not declared

    console.log(y);
}

// fastAndLoose();


//-------------------Spread and Rest Operators-----------------------------
//Spread operator: 

let arr = [5,6,72,3,2,1];
let arr2 = arr; 
//let arr2 = [...arr];

// console.log(arr);
// console.log(arr2);

let arr3 = [...arr,...arr2];
// arr3 = arr + arr2; doesn't work too well either 

let arr4 = [-2,3,...arr,51, ...arr2];

// console.log(arr3);
// console.log(arr4);

//Rest operator 
function variableArguments(...input){
    for(let i of input){
        console.log(i);
    }
}

// variableArguments(1,2,3,4);
// variableArguments([1,2,3]);
// variableArguments(1,2,3);
// variableArguments(arr);
// variableArguments(...arr);


//-----------Iteratos, Iterables and Generators-------------------

//Iterables
// Objects that have an iterators in them. 
// This allows them to be leveraged by other function, most notably the "for of"

//Iterator: 
// An iterator is an object that defines a sequence for us. 
// A iterator object has a "next()" method, which will either return the next value in the sequence 
// or it will return "finsh" status

//An example is an array 
let newArray = [27,81,85,23];

//arrays can be used with a for of loop
// for(let i of newArray){
//     console.log(i);
// }

//the next method will return 2 values, the value of the next sequence and whether it is "done".
let iterator = newArray[Symbol.iterator]();
// console.log(iterator);
// console.log(iterator.next());
// console.log(iterator.next());
// console.log(iterator.next());
// console.log(iterator.next());
// console.log(iterator.next());


// let looping = true;
// while(looping){

//     looping = iterator.next().done;
// }


//Making our own iterator

function createIterator(start=0,end=10,step=1){
    // let start = 0; //starting condtion
    // let end = 10; // ending condition
    // let step = 2; // incrementing 1 step at a time

    let nextIndex = start;

    const rangeIterator = {

        next(){
            let result;
            if( nextIndex < end){ //there are still more elements
                result = {value: nextIndex, done: false}
                nextIndex += step; //increment by the step value
                return result;
            }else{
                return {value:end, done: true}
            }
        }
    }

    return rangeIterator;
}

let myOwnIterator = createIterator(-100,100,7);

// let looping = true;
// while(looping){

//     let result = myOwnIterator.next();

//     console.log(result.value);

//     if(result.done == true){
//         looping = false;
//     }
    
// }

//Generator Function: 
// This is an alternative to creating an iterator.
// We can define a special function to create and return a generator, the generator will keep 
// sequencing until it stop at the yield we have provided.  

function* makeGeneratorIterator(start=0,end=10,step=1){
    let count = 0;
    for(let i = start; i<end; i+=step){
        count++;
        yield i;
    }
    return count;
}

let myGenerator = makeGeneratorIterator(-10,20,2);
let result = myGenerator.next();
console.log(result);

while(result.value < 20){
    console.log(result.value);
    result = myGenerator.next();
}

// let looping = true;
// while(looping){

//     let result = makeGeneratorIterator.next();

//     console.log(result.value);

//     if(result.done == true){
//         looping = false;
//     }
    
// }
