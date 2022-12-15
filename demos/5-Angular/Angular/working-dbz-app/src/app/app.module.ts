import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

// Import the module from the SDK
import { AuthModule } from '@auth0/auth0-angular';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CorsInterceptorService } from './services/cors-interceptor.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginButtonComponent } from './components/login-button/login-button.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { environment } from 'src/environments/environment';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AboutComponent } from './components/about/about.component';
import { ViewAllComponent } from './components/blogs/view-all/view-all.component';
import { CreateComponent } from './components/blogs/create/create.component';
import { BrowseComponent } from './components/browse/browse.component';
import { RegisterComponent } from './components/register/register.component';

import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { SearchComponent } from './components/search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginButtonComponent,
    NavbarComponent,
    AboutComponent,
    ViewAllComponent,
    CreateComponent,
    BrowseComponent,
    RegisterComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    MdbModalModule,
     // Import the module into the application, with configuration
     AuthModule.forRoot({
      domain: environment.AUTH0_DOMAIN,
      clientId: environment.AUTH0_CLIENT_ID
    })
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: CorsInterceptorService,
      multi: true,
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
