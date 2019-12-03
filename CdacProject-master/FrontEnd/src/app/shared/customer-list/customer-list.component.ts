import { Component, OnInit } from '@angular/core';
import { ConnectService } from 'app/services/connect.service';
import { Customer } from 'app/models/customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})

export class CustomerListComponent implements OnInit {

  emp: Customer[];
  modeldata: Array<Customer>;
  constructor(private _connect: ConnectService) { }

  ngOnInit() {
    this._connect.Getcust().subscribe((data) => {
      console.log("Customer list : "+JSON.stringify(data));
      this.emp = data;
    });
  }

}
