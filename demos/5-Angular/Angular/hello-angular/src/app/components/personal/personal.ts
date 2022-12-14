

//I need to provide Angular metadata on what this class is meant to be 
//In this case, I want a component. So I use a decorator 
//A component consits of a html file, a css file, a ts file (and a spec.ts)

import { Component } from "@angular/core";

@Component({ //key value pairs for more metadata
    selector: 'personal-tag', //how we refer to this component from other html components
    templateUrl: 'personal.html', //refer to the html file
    styleUrls: [] // styleUrls is an array, can have multiple stylesheets. 
})
export class PersonalComponent {

}