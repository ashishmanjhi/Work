import { Component, OnInit } from '@angular/core';
import { ConnectService } from 'app/services/connect.service';

@Component({
  selector: 'app-trans-history',
  templateUrl: './trans-history.component.html',
  styleUrls: ['./trans-history.component.css']
})
export class TransHistoryComponent implements OnInit {
emp:Array<string | number>;
  constructor(private _connect:ConnectService) { }

  ngOnInit() {
    return this._connect.Gettrans().subscribe((data) => {

      console.log(data);

      this.emp = data;
  });
}
}
