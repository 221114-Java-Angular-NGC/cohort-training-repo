import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { CreateComponent } from './components/blogs/create/create.component';
import { ViewAllComponent } from './components/blogs/view-all/view-all.component';
import { BrowseComponent } from './components/browse/browse.component';

import { HomeComponent } from './components/home/home.component';
import { LoginButtonComponent } from './components/login-button/login-button.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthGuard } from './guards/auth.guard';

//each component will have a URI corrlated as its route
//this is stored as an array of objects in this class
const routes: Routes = [
  {
    path: 'login',
    component: LoginButtonComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    //to apply our route guard, we have to set a CanActivate property for the route that we are protecting
    canActivate: [AuthGuard]
  },
  {
    path: 'blogs/view-all',
    component: ViewAllComponent
  },
  {
    path: 'blogs/create',
    component: CreateComponent
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'browse/:searchTerm',
    component: BrowseComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'browse',
    component: BrowseComponent
  },
  //it is common practice to also set a default route for our index pages in our app (aka start pages)
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
