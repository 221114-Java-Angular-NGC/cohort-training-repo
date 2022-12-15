import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginTemplate } from 'src/app/models/login-template';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login-button',
  templateUrl: './login-button.component.html',
  styleUrls: ['./login-button.component.css']
})
export class LoginButtonComponent implements OnInit {
  public user = new LoginTemplate("", "");
  public isAuthenticated$: any;

  public showLogIn: boolean = true;
  public showLogout: boolean = true;

  constructor(@Inject(DOCUMENT) public document: Document, public userService: UserService, public router: Router) { }

  ngOnInit(): void {
    console.log('Checking current location:' + window.location.href)
    let target: HTMLElement | null = this.document.getElementById("login-container");
    console.log("Target: " + target!.id);
    if(window.location.href === "http://localhost:4200/login" || window.location.href === "http://dbz-api.s3-website-us-east-1.amazonaws.com/login"){
      console.log("on login page")
      target!.style.display = "initial";
    }else{
      console.log("On page: " + window.location.href.replace("http://localhost:4200/", "").replace("http://dbz-api.s3-website-us-east-1.amazonaws.com/", ""))
    }
  }

  login(event: any){
    console.log("Form data: " + this.user);
    this.isAuthenticated$ = this.userService.login(this.user.username, this.user.password);
    console.log("Authenication granted: " + this.isAuthenticated$);
    if(this.isAuthenticated$ == true){
      console.log("redirecting to homepage...")
    }
  }

  logout(){
    console.log('logout event triggered. Location:' + this.document.location.origin);
    this.userService.logout();
    console.log('event complete');
  }

}
