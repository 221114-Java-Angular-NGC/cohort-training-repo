import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../services/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  isAuthenicated: boolean = false;

  constructor(public userService: UserService, public router: Router){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      console.log('CanActivate called');

    //let our service check with our backend server to see if this is a valid user
    let isLoggedIn = this.userService.getAuthStatus();

    if (isLoggedIn){
      return true;
    } else {
      this.router.navigate(['/login']);
    }
  }
  
}
