
/**
 * Fetch API is a newer version of XMLHttpRequest, with more abstraction and more 
 *  features (e.g. sending of cross origin requests)
 * 
 * With fetch fcuntions, we get them from the browser, specifically from the "window" object./
 * With fetch functions, they will implicitly return a Promise object.
 * 
 * A promise is used to handly asynchronous operations in Javascript 
 *      A promise objects will have one of 3 states: 
 *      1) Pending 
 *      2) Fulfilled 
 *      3) Rejected
 * 
 * With these states we can use follow up methods .then(), .catch() and .finally() to respond 
 *  to the promise, once it has been concluded. 
 * 
 * In JS we also have the "async" and "await" keywords
 * 
 *  async: will denote a function to be asynchronous - i.e. it will return a promsie!
 * 
 * await: is only valid inside of async functions. await forces JS to wait until the promise has been
 * settled 
 */

//  document.getElementById("pokemonButton").addEventListener('click',fetchPokemon);

document.getElementById("pokemonButton").addEventListener('click',fetchPokemon);


//An example of how to use async and await keywords within our own function
async function uselessfetchPokemon(){

    let pokemonId = "asdf"
    let baseURL = "https://pokeapi.co/api/v2/pokemon/";
    let url = baseURL + pokemonId;

    // let response = await fetch(url,{method:"POST",}); example of passing in optional information with request

    let response = await fetch(url);

    return response;

}

function fetchPokemon(){
    let pokemonId = document.getElementById("pokemonId").value;
    let baseURL = "https://pokeapi.co/api/v2/pokemon/";
    let url = baseURL + pokemonId;

    fetch(url).then((response) => {

        console.log(response);
        return response.json(); //converts the response into just the body.

    }).then( function(daResponse){

        console.log(daResponse);

        return daResponse;

    }).then((daResponse) => {

        DOMManipulation(daResponse);
    }
    ).catch(
        function(daResponse){
            console.log()
            console.log("we've got an error!")
        }
    )
}

function DOMManipulation(pokemon){

    //setting the name
    document.getElementById("pokemonName").innerHTML = pokemon.name;

    //setting the image 
    let pokeImg = document.getElementById("pokemonImg");
    pokeImg.setAttribute("src", pokemon.sprites.front_shiny);
}


