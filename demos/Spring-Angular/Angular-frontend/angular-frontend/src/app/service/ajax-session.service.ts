import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Message } from '../models/message';

@Injectable({
  providedIn: 'root'
})
export class AjaxSessionService {

  //We'll be using HttpClient to communicate over HTTP
  constructor(private myClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'}),
    withCredentials: true
  }

  loginRequest(): Observable<Message> { 
    
    //Angular, like Spring, does not trust other domains. 
    // IT will not send over any cookies, tokens or sessions to other domains by default 

    return this.myClient.get<Message>("http://localhost:7000/login",{withCredentials:true});
  
  } // 

  logoutRequest(): Observable<any>{

   return this.myClient.get("http://localhost:7000/logout",{withCredentials:true});
  }

  booleanCheckSession(): Observable<boolean>{
    return this.myClient.get<boolean>("http://localhost:7000/checkAccess",{withCredentials:true});
  }
}
