import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ClientMessage } from '../models/client-message';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  isAuthenticated: boolean = false;
  user$!: User; //! = variable cannot have null/undefined values, $ refers to that component/object instance
  url: string = environment.APP_URL; //this value for our server will be stored in the environment.ts (aka our backend url)
  
  //httpclient allows use to make HTTP requests to our server and return our info inside of an Observable

  //Observables are similar to promises in JS but they only emit their info to its subscribers via subscribe
  
  //now for this service to use HTTPClient, it has to be injected into this service's constructor
  //this is known as dependency injection
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

  register(user: User): void {
    localStorage.clear();

    let body = {
      username: user.username,
      password: user.password,
      firstName: user.firstname,
      lastName: user.lastname,
      email: user.email
    };

    this.http.post<ClientMessage>(`${this.url}users/register`, JSON.stringify(body))
    .subscribe(data => {
          console.log(data);
        }
    );
  }

  login(username: string, password: string):boolean{
    console.log("in userservice method: login start")
    let body = {
      username: username,
      password: password
    };

    console.log("in userservice method: body=" + body)

    //this is an httpclient usage example
    //http client will have built-in methods for each HTTP verb
    //now any component that is subscribed to this service will have access to this info through the login() method
    this.http.post<ClientMessage>(`${this.url}users/login`, JSON.stringify(body))
    .subscribe(data => {
          console.log("Backend data: " + data);
          localStorage.setItem("current-user", username);
          this.isAuthenticated = true;
          console.log("isAuthenticated: " + this.isAuthenticated);
        }
    );

    console.log("in userservice method: getting current user...")
    this.http.get<User>(`${this.url}users/find-by-username?username=${username}`)
    .subscribe(data => {
          console.log(data);
          this.user$ = new User(data.id, data.username, data.password, data.firstname, data.lastname, data.email);
          let test = JSON.stringify(this.user$);
          console.log("test data: " + test)
          localStorage.setItem("current-user", this.user$.username); 
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
