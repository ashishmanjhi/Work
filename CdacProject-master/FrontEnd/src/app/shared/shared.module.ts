import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CarStockComponent } from './car-stock/car-stock.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { SearchComponent } from './search/search.component';
import { TransHistoryComponent } from './trans-history/trans-history.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    CarStockComponent,
    CustomerListComponent,
    SearchComponent,
    TransHistoryComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports : [
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    CarStockComponent,
    CustomerListComponent,
    SearchComponent,
    TransHistoryComponent,
    FormsModule
  ]
})

export class SharedModule { }
