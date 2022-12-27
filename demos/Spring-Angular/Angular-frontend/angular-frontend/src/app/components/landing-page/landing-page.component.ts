import { Component } from '@angular/core';
import { AjaxSessionService } from 'src/app/service/ajax-session.service';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent {

  loginMessage: string = "";
  logoutMessage: string = "";
  userDetails: string = "";

  firstButton(){

    this.ajaxService.loginRequest().subscribe(
      httpMessage => {
        this.loginMessage += ` ${httpMessage.message}`;
      }
    )
  }

  secondButton(){
    this.ajaxService.logoutRequest().subscribe(
      () => {
        this.logoutMessage += " logged out!"
      }
    );
  }

  thirdButton(){

    this.ajaxService.booleanCheckSession().subscribe(
      booleanValue => {
        if(booleanValue){
          this.userDetails += " looks like Bob";
        }else{
          this.userDetails += " there's no Bob!"
        }
      }
    )
  }

  constructor(private ajaxService: AjaxSessionService){};

}
