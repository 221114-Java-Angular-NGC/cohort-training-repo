import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  //each component will have a URI corrlated as its route
  //this is stored as an array of objects in this class
  {
    component: LoginComponent,
    path: "login"
  },
  //it is common practice to also set a default route for our index pages in our app (aka start pages)
  {
    path: "",
    redirectTo: "/login",
    pathMatch: "full"

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
