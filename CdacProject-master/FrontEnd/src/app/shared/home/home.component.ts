import { Component, OnInit } from '@angular/core';
import { Car } from 'app/models/car';
import { Router } from '@angular/router';
import { EmployeeService } from 'app/services/employee.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  modeldata: Array<Car>;
  username: string;
  password: string;

  constructor(private router: Router,
    private employee: EmployeeService) { }

  ngOnInit() { }

  user = "Employee";

  Admin() {
    this.user = "Admin";
  }

  Employee() {
    this.user = "Employee";
  }

  getUser(value: string) {
    this.username = value;
  }

  getPass(value: string) {
    this.password = value;
  }

  Login() {
    this.employee.Getlogin(this.username, this.password).subscribe((data) => {
      console.log(" Home : getlogin " + data);

      this.employee.emp = data;

      if (this.user == "Admin") {
        if (this.employee.emp[0].type == "admin") {
          console.log("Home : logging in admin");
          this.employee.login.next(true);
          this.router.navigate(['AdminDashboard']);
        }
      } else if (this.user == "Employee") {
        if (this.employee.emp[0].type == "emp") {
          this.employee.login.next(true);
          this.router.navigate(['EmployeeDashboard']);
        }
      }
    });
  }
}
