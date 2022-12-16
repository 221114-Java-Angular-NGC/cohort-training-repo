import { outputAst } from '@angular/compiler';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { User } from '../../models/user'

@Component({
  selector: 'app-profile-details',
  templateUrl: './profile-details.component.html',
  styleUrls: ['./profile-details.component.css']
})
export class ProfileDetailsComponent implements OnInit {

  //in order for our info from our child here to our parent, we will use
  //the @Input decorator here
  @Input() user: User = new User(0, "", "", "", "", "");

  //for this component to send our updates to the parent, we must
  //use an eventemitter
  @Output() userChanges: EventEmitter<User> = new EventEmitter<User>();

  constructor() { }

  ngOnInit(): void {
  }

  update(){
    //just emitting that new user's changes to the parent
    this.userChanges.emit(this.user);
  }

}
