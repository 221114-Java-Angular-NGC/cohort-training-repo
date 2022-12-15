import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { CreateComponent } from './components/blogs/create/create.component';
import { ViewAllComponent } from './components/blogs/view-all/view-all.component';
import { BrowseComponent } from './components/browse/browse.component';

import { HomeComponent } from './components/home/home.component';
import { LoginButtonComponent } from './components/login-button/login-button.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginButtonComponent
  },
  {
    path: 'home',
    component: HomeComponent
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
