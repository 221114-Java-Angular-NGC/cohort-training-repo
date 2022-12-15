import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { environment } from 'src/environments/environment';
import { ClientMessage } from '../models/client-message';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  //httpclient allows use to make HTTP requests to our server and return our info inside of an Observable

  //Observables are similar to promises in JS but they only emit their info to its subscribers via subscribe
  isAuthenticated: boolean = false;
  user$!: User; //! = variable cannot have null/undefined values, $ refers to that component/object instance
  url: string = environment.APP_URL; //this value for our server will be stored in the environment.ts
  
  //now for this service to use HTTPClient, it has to be injected into this service's constructor
  constructor(private http: HttpClient, private router: Router) { }
  
  //authenication methods
  getAuthStatus() {
    if(this.isAuthenticated){
      console.log(`Access granted. Current User: ${localStorage.getItem("current-user")}`)
    }else{
      console.log(`Sorry, no authenication token present for this session. Please login to resolve this issue.`)
    }
    return this.isAuthenticated;
  }


  login(username: string, password: string):boolean{
    console.log("in userservice method: login start")

    //get form values
    let body = {
      username: username,
      password: password
    };

    console.log("in userservice method: body=" + body)

    //this is an httpclient example
    this.http.post<ClientMessage>(`${this.url}users/login`, JSON.stringify(body))
    .subscribe(data => {
          console.log("Backend data: " + data);
          localStorage.setItem("current-user", username);
          this.isAuthenticated = true;
          console.log("isAuthenticated: " + this.isAuthenticated);
        }
    );

    
    this.router.navigateByUrl('/home');
    
    console.log("From service - auth finished=" + this.isAuthenticated);
    return this.isAuthenticated;
  }

  logout(){
    localStorage.clear();
    this.isAuthenticated = false;
  }

  //server methods
}
