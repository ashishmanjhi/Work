import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-empdetails',
  templateUrl: './empdetails.component.html',
  styleUrls: ['./empdetails.component.css']
})
export class EmpdetailsComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() { }
  
  backClicked() {
    this.router.navigate(['AdminDashboard'])
  }

}

