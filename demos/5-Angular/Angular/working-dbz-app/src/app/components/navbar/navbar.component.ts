import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { UserService } from 'src/app/services/user.service';
import { CreateComponent } from '../blogs/create/create.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isCollapsed = true; 
  currentUserName: string | undefined;
  modalRef: MdbModalRef<CreateComponent> | null = null;
  
  constructor(public auth: UserService, private modalService: MdbModalService, private router: Router) { }

  ngOnInit(): void {
    if(localStorage.getItem("current-user")){
      let value = localStorage.getItem("current-user");
      this.currentUserName = `${value}`;
    }else{
      this.currentUserName = "";
    }
   }

  public closeMenuEvent() {
    console.log('event triggered');
    this.isCollapsed = !this.isCollapsed;
  }

  openModal() {
    this.modalRef = this.modalService.open(CreateComponent)
  }

  logout(event: any){
    localStorage.clear();
    this.router.navigateByUrl("/login");
  }
}
