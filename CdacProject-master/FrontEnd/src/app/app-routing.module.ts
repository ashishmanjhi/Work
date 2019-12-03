import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './shared/home/home.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: "home",
    pathMatch: "full"
  },
  {
    path: 'AdminDashboard',
    loadChildren: 'app/admin/admin.module#AdminModule'
  },
  {
    path: 'EmployeeDashboard',
    loadChildren: 'app/emp/emp.module#EmpModule'
  },
  {
    path: 'home',
    component : HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
