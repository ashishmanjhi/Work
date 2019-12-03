import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'app/models/customer';
import { ConnectService } from 'app/services/connect.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-custdetails',
  templateUrl: './custdetails.component.html',
  styleUrls: ['./custdetails.component.css']
})

export class CustdetailsComponent implements OnInit {

  custId: Number;
  FName: string;
  LName: string;
  ContactNo: Number;
  Address: string;
  Email: string;

  cust: Customer;
  rows: Observable<number>;
  constructor(private router: Router) { }

  ngOnInit() { }

  save(event: Event) {

    this.cust = new Customer(this.custId, this.FName, this.LName, this.ContactNo, this.Address, this.Email);

    console.log("Cust Details" + JSON.stringify(this.cust));

    this.router.navigate(['EmployeeDashboard/cardetails'], { state: { data: this.cust } });
  }

  backClicked() {
    javascript: history.go(-1);
  }

}
