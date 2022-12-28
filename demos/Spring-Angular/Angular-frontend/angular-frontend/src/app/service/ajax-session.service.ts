import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Message } from '../models/message';

@Injectable({
  providedIn: 'root'
})
export class AjaxSessionService {

  url: string = "http://ec2-3-134-96-49.us-east-2.compute.amazonaws.com:7000";

  //We'll be using HttpClient to communicate over HTTP
  constructor(private myClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'}),
    withCredentials: true
  }

  loginRequest(): Observable<Message> { 
    
    //Angular, like Spring, does not trust other domains. 
    // IT will not send over any cookies, tokens or sessions to other domains by default 

    return this.myClient.get<Message>(this.url + "/login",{withCredentials:true});
  
  } // 

  logoutRequest(): Observable<any>{

   return this.myClient.get(this.url + "/logout",{withCredentials:true});
  }

  booleanCheckSession(): Observable<boolean>{
    return this.myClient.get<boolean>(this. url + "/checkAccess",{withCredentials:true});
  }
}
