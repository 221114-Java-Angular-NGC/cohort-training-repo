import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(@Inject(DOCUMENT) public document: Document, public userService: UserService, public router: Router) { }

  ngOnInit(): void {
    console.log('Checking current location:' + window.location.href)
    console.log("Test: " + window.location.href.replace("http://localhost:4200/", "").replace("http://dbz-api.s3-website-us-east-1.amazonaws.com/", ""))
  }

}
