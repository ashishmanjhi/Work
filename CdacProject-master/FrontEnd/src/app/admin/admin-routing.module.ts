import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { CarStockComponent } from 'app/shared/car-stock/car-stock.component';
import { CustomerListComponent } from 'app/shared/customer-list/customer-list.component';
import { TransHistoryComponent } from 'app/shared/trans-history/trans-history.component';
import { EmplistComponent } from './emplist/emplist.component';
import { EmpdetailsComponent } from './empdetails/empdetails.component';

const routes: Routes = [
  {
    path: '',
    component: AdminDashboardComponent,
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
      },
      {
        path: 'emplist',
        component: EmplistComponent,
        outlet: 'sub'
      }
    ]},
    {
      path:'empdetails',
      component: EmpdetailsComponent
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AdminRoutingModule { }
