import { Component, OnInit } from '@angular/core';
import { ConnectService } from 'app/services/connect.service';
import { Employee } from 'app/models/employee';

@Component({
  selector: 'app-emplist',
  templateUrl: './emplist.component.html',
  styleUrls: ['./emplist.component.css']
})

export class EmplistComponent implements OnInit {
emp:Employee[];
  modeldata: Array<Employee>;
  constructor(private _connect:ConnectService) { }

  ngOnInit() {
    return this._connect.Getemployee().subscribe((data) => {
      console.log(data);
      this.emp = data;
    });
  }

  delete(client: any) {
    console.log(client);
  };
}

