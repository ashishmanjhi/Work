import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ConnectService } from 'app/services/connect.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {


  constructor(private router:Router,private _connect:ConnectService, private route : ActivatedRoute) { }

  ngOnInit() {
    console.log("admin dashboard");
  }

  viewCust(){
    this.router.navigate([{ outlets: { sub: ['cust'] } }], {relativeTo: this.route});
  }

  viewCarStock(){
    this.router.navigate([{ outlets: { sub: ['car'] } }], {relativeTo: this.route});
  }

  transHistory(){
    this.router.navigate([{ outlets: { sub: ['trans'] } }], {relativeTo: this.route});
  }

  addEmployee(){
    this.router.navigate(['AdminDashboard/empdetails'])
  }

  vieEmpList(){
    this.router.navigate([{ outlets: { sub: ['emplist'] } }], {relativeTo: this.route});
  }
}
