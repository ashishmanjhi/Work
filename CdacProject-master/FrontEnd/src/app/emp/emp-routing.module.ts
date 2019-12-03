import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import { CarStockComponent } from 'app/shared/car-stock/car-stock.component';
import { CustomerListComponent } from 'app/shared/customer-list/customer-list.component';
import { TransHistoryComponent } from 'app/shared/trans-history/trans-history.component';
import { EmpdetailsComponent } from 'app/admin/empdetails/empdetails.component';
import { CardetailsComponent } from './cardetails/cardetails.component';
import { CustdetailsComponent } from './custdetails/custdetails.component';

const routes: Routes = [
  {
    path: '',
    component: EmployeeDashboardComponent,
    children: [
      {
        path: '',
        component: CarStockComponent,
        outlet: 'sub'
      },
      {
        path: 'cust',
        component: CustomerListComponent,
        outlet: 'sub'
      },
      {
        path: 'car',
        component: CarStockComponent,
        outlet: 'sub'
      },
      {
        path: 'trans',
        component: TransHistoryComponent,
        outlet: 'sub'
      }]
  },
  {
    path:'cardetails',
    component:CardetailsComponent
  },
  {
    path:'custdetails',
    component:CustdetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class EmpRoutingModule { }
