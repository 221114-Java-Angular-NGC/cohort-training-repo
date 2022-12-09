
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

variableArguments(1,2,3,4);
variableArguments([1,2,3]);
variableArguments(1,2,3);
variableArguments(arr);
variableArguments(...arr);