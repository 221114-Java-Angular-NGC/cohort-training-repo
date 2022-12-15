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
  user$!: User;
  url: string = environment.APP_URL;
  
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
