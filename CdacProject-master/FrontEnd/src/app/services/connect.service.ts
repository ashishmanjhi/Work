import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from 'app/models/employee';
import { Customer } from 'app/models/customer';
import { Car } from 'app/models/car';
import { EmployeeService } from './employee.service';

@Injectable({
  providedIn: 'root'
})

export class ConnectService {
  constructor(private _http: HttpClient , private employee : EmployeeService) { }
  uri = 'http://localhost:3000';

  Getemployee() {
    let urilink = "/employee";
    return this._http.get<Employee[]>(this.uri + urilink);
  }

  Getcust() {
    let urilink = "/customer";
    return this._http.get<Customer[]>(this.uri + urilink);
  }

  Getcar() {
    let urilink = "/car";
    return this._http.get<Car[]>(this.uri + urilink);
  }

  Gettrans() {
    let urilink = "/transact";
    return this._http.get<string[]>(this.uri + urilink);
  }

  PostCust(cust : Customer , car : Car ){
    let urilink = "/invoice";
    return this._http.post<string>(this.uri + urilink,{"cust" : cust , "car" : car , "empId" : this.employee.emp.empId});
  }

  GetCarSearch(x:string)
  {
    let urilink="/carsearch?Manufacturer="+x;
    return this._http.get<Car[]>(this.uri+urilink);
  }
}