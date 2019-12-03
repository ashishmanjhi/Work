import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-dashboard',
  templateUrl: './employee-dashboard.component.html',
  styleUrls: ['./employee-dashboard.component.css']
})
export class EmployeeDashboardComponent implements OnInit {

  showCust: boolean;
  showCarStock: boolean;
  showTransHist: boolean;

  constructor(private router:Router , private route: ActivatedRoute) { }

  ngOnInit() {
    console.log("employee dashboard");
  }

  newTrans(){
    this.router.navigate(['EmployeeDashboard/custdetails']);
  }

  viewCust(){
    // this.router.navigate(['EmployeeDashboard/cust'])
    this.router.navigate([{ outlets: { sub: ['cust'] } }], {relativeTo: this.route});
  }

  viewCarStock(){
    // this.router.navigate(['EmployeeDashboard/car']);
    this.router.navigate([{ outlets: { sub: ['car'] } }], {relativeTo: this.route});
  }

  transHistory(){
    // this.router.navigate(['EmployeeDashboard/trans']);
    
    this.router.navigate([{ outlets: { sub: ['trans'] } }], {relativeTo: this.route});
  }
}
