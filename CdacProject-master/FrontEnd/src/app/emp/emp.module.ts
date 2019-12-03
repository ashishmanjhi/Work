import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmpRoutingModule } from './emp-routing.module';
import { SharedModule } from 'app/shared/shared.module';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import { CustdetailsComponent } from './custdetails/custdetails.component';
import { CardetailsComponent } from './cardetails/cardetails.component';
import { InvoiceComponent } from './invoice/invoice.component';

@NgModule({
  declarations: [
    EmployeeDashboardComponent,
    CardetailsComponent,
    CustdetailsComponent,
    InvoiceComponent
  ],
  imports: [
    CommonModule,
    EmpRoutingModule,
    SharedModule
  ]
})

export class EmpModule { }
