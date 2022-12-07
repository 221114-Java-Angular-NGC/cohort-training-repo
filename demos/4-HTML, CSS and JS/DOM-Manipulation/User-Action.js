/**
 * 
 * Events are predefined in the document. We can use the inbuilt HTML event functionality 
 * but it's better to use JS since we can add in a lot more logic. 
 * 
 * We're going to start of with HTML events (refer to index)
 * In HTML we can do very basic logic that correspond to events
 */

/**
 * 0) (We define a function to trigger when an event happens)
 * 1) First we select the elment we want
 * 2) We want to add an event Listener to that button
 */

//This method will update the first button to add the number of clicks we've done so far.
let i = 1;
function basicDOMManipulation(apple){
    let button = document.getElementById("first-button");
    button.innerHTML = `Click again! : You've selected me ${i}`;
    i++;

    console.log(apple.offsetX);
    console.log(apple.offsetY);
}


function turnEverythingIntoPargraphs(event){
    
    let body = document.querySelector("body");
    
    let para = document.createElement("p");
    para.innerHTML = "<b><i>New paragraphs!</i></b>";

    body.appendChild(para);

    console.log(event.path[0].innerHTML);

    event.path[0].innerHTML = "I've been activated!";
    
}

//Find the element we want to tie an event to
let myButton = document.getElementById("first-button");
let secondButton = document.getElementById("second-button");

/**
 * We want to associate user actions to programatic logic. 
 * User actions are a subset of events that occur in JS
 * An event can be: 
 *      click 
 *      mousehover
 *      mouseenter
 */
myButton.addEventListener('click', basicDOMManipulation);
secondButton.addEventListener('dblclick',turnEverythingIntoPargraphs);




//Non user driven event 
// When the page loads, we would then like to do the functinoality 
window.onload = () =>{
    let thirdButton = document.getElementById("third-button");
    thirdButton.addEventListener('mouseover',turnEverythingIntoPargraphs);
}