import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User(0, "", "", "", "", "");
  isRegistered: boolean = false;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  register(event: any){
    console.log(this.user);

    if(this.user.username !== "" &&
        this.user.password !== "" && 
        this.user.firstname !== "" && 
        this.user.lastname !== "" &&
        this.user.email !== "")
      {

      this.service.register(this.user);
      this.router.navigateByUrl('/login');
    }else{
      throw new Error("Empty fields in form!");
    }
  }
}
