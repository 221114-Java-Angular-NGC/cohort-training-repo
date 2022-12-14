import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PersonalComponent } from './components/personal/personal';
import { TestComponent } from './components/test/test.component';
import { PlanetListComponent } from './components/planet-list/planet-list.component';
import { PrependPipe } from './pipes/prepend.pipe';
import { ColorDirectiveDirective } from './directives/color-directive.directive';
import { PlanetGeneratorService } from './services/planet-generator.service';
import { FormsModule } from '@angular/forms';
import { PokemonPageComponent } from './components/pokemon-page/pokemon-page.component';
import { AppRoutingModule } from './app-routing.module';

//Where we provide information to Angular on all of our components, services, pipes, anything that we create or use. 
// Declares the existence and location of all our Angular files 
// It doesn't have a "selector" or "StyleUrls" because this is not used as a view. 
@NgModule({
  declarations: [ //Where we declare our components, pipes and (custom) directives 
    AppComponent,
    PersonalComponent,
    TestComponent,
    PlanetListComponent,
    PrependPipe,
    ColorDirectiveDirective,
    PokemonPageComponent
  ],
  imports: [ // used to import external modules, from node_modules 
    BrowserModule,
    FormsModule, //ngModel comes from this Library
    AppRoutingModule
  ],
  providers: [ // used to declare services 
    /**
     * Angular has an "Injector" which will look for services declared in the providers or 
     *  it will check the "root" folder for any classess with the @Injectable decorator.
     */
    PlanetGeneratorService
  ],
  bootstrap: [AppComponent] // treats the app.component special 
})
export class AppModule { } //just another class 
