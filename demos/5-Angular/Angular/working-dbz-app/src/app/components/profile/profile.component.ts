import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  //this is just for our eventemitter demo
  //highly recommend that your users come from your server (which is accessible via our UserService)
  users: User[] = [
    { id: 1, username: "aaknoc", password: "password", firstname: "Azhya", lastname: "Knocks", email: ""}
  ];

  selectedUser: User = new User(0, "", "", "", "", "");

  constructor(public service: UserService) { }

  ngOnInit(): void {
  }

  showDetails(user: User){
    this.selectedUser = Object.assign({}, user);
  }

  update(user: User){
    console.log("New user info: " + user);
    let u = this.users.find(t => t.id == user.id);
    //this will replace old info with the new
    Object.assign(u, user);
    alert("User info has been saved.");
  }

}
