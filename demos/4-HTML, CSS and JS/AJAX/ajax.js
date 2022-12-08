
/**
 * AJAX: Asynchronous Javascript and XML
 * 
 *  A technique for accessing web servers from a web page asynchronously. 
 * 
 *  Synchronous vs asynchronous: 
 *      Javascript is a single threaded language. 
 *      Synchronous operations are blocking, i.e. the thread will not continue until the 
 *          operation is complete. 
 *      Asynchronous operations allow the rest of the application/web page to still carry 
 *          on working until the opration comes to its conclusion.
 * 
 *      (i.e. we won't have to wait for the server to respond )
 * 
 * In Javascript we have the "Fetch API" which is an abstraction on the asynchronous tools that 
 *     JS uses. It is very nice, and has more features than what I'll be showing you. 
 * 
 * I'll be showing you the XMLHttpObject 
 */


document.getElementById("pokemonButton").addEventListener('click',getPokemon);

//I'm sending a GET request to the Poke API
function getPokemon(){
    
    //From the User I will require a number or name, or some kind of input. I'm choosing number
    let pokemonId = document.getElementById("pokemonId").value; //only works with input type
    console.log(pokemonId);

    /**
     * How does AJAX work here?
     * 
     * 1) An XMLHttpRequest Object is created
     * 2) XMLHttpRequest object sends a request to the web server
     * 3) Server processes the request 
     * 4) Server sends a request back 
     */

    let xhttp = new XMLHttpRequest();
    let baseURL = "https://pokeapi.co/api/v2/pokemon/";

    xhttp.onreadystatechange = function(){

        /**
         * 0 - Request not initialized 
         * 1 - Server connection established 
         * 2 - Request has been received by the server
         * 3 - Server is processing request 
         * 4 - Request is finished and response is ready 
         */

        // console.log(`Changing my ready state to ${xhttp.readyState}` );

        if(xhttp.readyState == 4 && xhttp.status == 200){
            //Request is complete and successful

            console.log(xhttp.responseText);

            let pokemon = JSON.parse(xhttp.responseText);

            DOMManipulation(pokemon);

        }else if(xhttp.readyState == 4 && xhttp.status == 404){
            alert(`That is not a valid request!`)
        }
    }

    xhttp.open("GET",baseURL + pokemonId);

    xhttp.send();


}


function DOMManipulation(pokemon){

    //setting the name
    document.getElementById("pokemonName").innerHTML = pokemon.name;

    //setting the image 
    let pokeImg = document.getElementById("pokemonImg");
    pokeImg.setAttribute("src", pokemon.sprites.front_shiny);
}