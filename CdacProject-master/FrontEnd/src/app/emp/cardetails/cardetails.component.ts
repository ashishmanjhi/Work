import { Component, OnInit } from '@angular/core';
import { Customer } from 'app/models/customer';
import { Router } from '@angular/router';
import { ConnectService } from 'app/services/connect.service';
import { Car } from 'app/models/car';
import { EmployeeService } from 'app/services/employee.service';

@Component({
  selector: 'app-cardetails',
  templateUrl: './cardetails.component.html',
  styleUrls: ['./cardetails.component.css']
})

export class CardetailsComponent implements OnInit {

  cust: Customer;
  car: Car;
  carId: number;
  model: string;
  color: string;
  year: number;
  rate: number;
  manufacturer: string;
  type: string;
  sale: string;

  constructor(private router: Router, private connect: ConnectService) {
    this.cust = this.router.getCurrentNavigation().extras.state.data;
    console.log("Cardetails : "+JSON.stringify(this.cust));
  }

  ngOnInit() { }

  Entry(event: Event, data) {
    event.preventDefault();
    console.log("car form : " + data);

    this.car = new Car(data.carId, data.model, data.color, data.year, data.rate, data.manufacturer, data.type, data.sale, this.cust.custId);
    console.log("my car model" + JSON.stringify(this.car));

    return this.connect.PostCust(this.cust, this.car).subscribe((data) => {
      console.log("invoice : " + data);
    });

  }

  backClicked() {
    javascript: history.go(-1);
  }

}
