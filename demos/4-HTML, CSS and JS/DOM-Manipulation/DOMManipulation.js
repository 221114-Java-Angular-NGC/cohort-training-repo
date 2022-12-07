/**
 * 
 * What is DOM? 
 * 
 *  Document Object Model 
 *  This is a representation of our html page, for Javascript to manipulate for us. 
 * 
 *  Because HTML is very hierarchal, i.e. tags within tags. We end up with a tree like 
 *  structure for our DOM.
 * 
 *                  -> meta charset
 *          -> head -> title
 *      html 
 *          -> body ->
 *                  ->
 *                  -> div -> div -> p
 */

//Document is an object with all the properties and tags of the webpage
// console.log(document);

// //depcreated property/method are no longer supported (but sometimes can still be accessible)
// console.log(document.all);

// console.log(document.all[8]); //This is a TERRIBLE way of selecting our elements
//                                 // because the elements can easily change position within the document.

// console.log(document.URL);
// console.log(document.title);

/** --------------------Selecting By ID--------------------------- */

let idElement;

idElement = document.getElementById("first-title");


//innerHTML will accept tags 
//innerText will not, and interpret everything as text (slighlty better practice)
idElement.innerHTML = "<i><b>Modified Title!</b></i>";
idElement.innerText = "Using the Inner Text to modify the title"; 


idElement.setAttribute("style","color:blue");
idElement.setAttribute("style","background-color:green;color:white");

idElement.setAttribute("class","first-js-html-class");

/** --------------------Selecting By Class--------------------------- */

let classElements = document.getElementsByClassName("last-paragraph");

// console.log(classElements);
// console.log(typeof(classElements[0]));

let i = 1;
for(let tag of classElements){
    tag.innerText = `MODIFYING ALL THE 
                        PARAGRAPH TAGS IN THE FOOTER`;
    tag.setAttribute("style","color:green");
    tag.setAttribute("id",`para-${i}`);
    i++;
}

/** --------------------Selecting By Tag Names--------------------------- */

let allAnchorTags = document.getElementsByTagName("a");

console.log(allAnchorTags);

for(let tag of allAnchorTags){

    console.log(tag.className);

    //We are disablling all tags that aren't already disabled
    if(tag.className != "nav-link disabled"){ 
        tag.className = "nav-link disabled";
        tag.innerHTML = `<strike>${tag.innerHTML}</strike>`;
    }
}

/** --------------------Query Selector --------------------------- */
//Query selector uses CSS selector syntax

let list = document.querySelector(".nav"); //Query selector will return only the first elment 
let body = document.querySelector("body"); 
let listOfParagraphs = document.querySelectorAll("p"); //return all elements that match 

console.log(list);


/** --------------------Creating a new elment  --------------------------- */
/**
 * 1) Create a new element from scratch 
 * 2) Find an existing element 
 * 3) Attach the new elment to the existing element
 */

//Created the element
let newH3 = document.createElement("h3");
newH3.innerHTML = "<b><i>Brand</b></i> new element from JS";
newH3.setAttribute("style","color:violet");

//Find an existing element
let header = document.querySelector("header"); 

//Attach it as a child element

header.appendChild(newH3);