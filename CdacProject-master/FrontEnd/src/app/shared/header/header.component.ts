import { Component, OnInit, Injectable } from '@angular/core';
import { EmployeeService } from 'app/services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {

  login : boolean;

  constructor(private router: Router , private empService : EmployeeService) { }

  ngOnInit() {
    if(this.empService.login){
      this.login = true;
    }else{
      this.login = false;
    }

    this.empService.login.subscribe(updatedLogin => {
      this.login = updatedLogin;
      console.log("login updated");
    });
    console.log("Header : "+this.empService.login +" "+ this.login);
  }

  openModalWithComponent() {
    this.router.navigate(['']);
    this.login = false;
  }

}