import { Component } from '@angular/core';
import { PlanetGeneratorService } from 'src/app/services/planet-generator.service';
import { Planet } from './planet';

@Component({
  selector: 'app-planet-list',
  templateUrl: './planet-list.component.html',
  styleUrls: ['./planet-list.component.css']
})
export class PlanetListComponent {

  //Used to demo interpolation 
  user: string = "Bobby";
  age: number = 10;

 //used to demo property binding 
 imageWidth = 100;
 imageMargin = 2;

  
  planets: Planet[];

  //used to demo filtering on table
  filteredPlanets: Planet[]; //make a new list of the filtered planets 
  inputField: string = ''; //which the user is going to input in the HTML

  get InputField(){ //getters
    return this.inputField;
  }

  set InputField(userInput: string){ //setter - set the value of the inputField and modify the filteredPlanets 
    this.inputField = userInput;

    console.log(this.inputField)

    if(this.InputField != ""){ // as long as there is some input, we'll perform a filter. 
      console.log("inside filter!")
      this.filteredPlanets = this.performFilter(userInput);
    }else{
      this.filteredPlanets = this.planets;
    }
  }

  performFilter(filterValue: string): Planet[]{ //actual filter function. 
    return this.planets.filter( //inbuilt method where we define the filter condition
      (planet:Planet) => { return planet.name.toLowerCase().indexOf(filterValue.toLowerCase())!= -1}
    )
  }



  //used to demo event binding
  showTable: boolean = true;

  toggleTable(): void {
    this.showTable = !this.showTable;
  }

  //Angular is handling the entire lifecycle of this components, so when it creates this component it will check the 
  // constructor to see if any services need to be "injected" in i.e. Dependency injection
  constructor(private planetGenerator: PlanetGeneratorService) {
  
      this.planets = this.planetGenerator.Planets;
      this.filteredPlanets = this.planets;
   }

}
