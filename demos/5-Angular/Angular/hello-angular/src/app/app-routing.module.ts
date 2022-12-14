import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { PlanetListComponent } from "./components/planet-list/planet-list.component";
import { PokemonPageComponent } from "./components/pokemon-page/pokemon-page.component";

const routes: Routes = [

    {
        path: 'planets',
        component: PlanetListComponent
    },
    {
        path: 'pokemon',
        component: PokemonPageComponent
    }

    //There are more routes you can add, you can also add regex to grab requests without a valid path. 
    //But I'll you all figure out that. 

]
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}