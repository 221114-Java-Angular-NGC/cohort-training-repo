import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SessionGuardGuard } from './routeGuards/session-guard.guard';

const routes: Routes = [
  // { path: 'secret', component: SecretPageComponent, canActivate: [SessionGuardGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
