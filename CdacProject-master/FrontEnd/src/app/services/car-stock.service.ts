import { Injectable } from '@angular/core';
import { Car } from 'app/models/car';

@Injectable({
  providedIn: 'root'
})
export class CarStockService {

  constructor() { }

  $cars : Car[];

  ngOnInit() {
    console.log("car stock loading cars");
  }

  // getCars(){

    
  //   let car=new Car(); 

  //   car.carId = 100;
  //   car.Model = 'civic';
  //   car.color = 'white';
  //   car.Year = 2014;
  //   car.Rate = 100000;
  //   car.Manufacture = 'Honda';
  //   car.Type = 'Hatchback';
  //   car.Sale = 'Y';

  //   (car)=>this.$cars;

  //   car.carId = 101;
  //   car.Model = 'Swift';
  //   car.color = 'red';
  //   car.Year = 2008;
  //   car.Rate = 500000;
  //   car.Manufacture = 'Maruti Suzuki';
  //   car.Type = 'Hatchback';
  //   car.Sale = 'Y';

  //   (car)=>this.$cars;

  //   car.carId = 102;
  //   car.Model = 'Rs';
  //   car.color = 'black';
  //   car.Year = 2016;
  //   car.Rate = 200000;
  //   car.Manufacture = 'Audi';
  //   car.Type = 'sport';
  //   car.Sale = 'N';

  //   (car)=>this.$cars;

  //   return this.$cars;
  // }

  // insertCar(carId : Number , ){
   
  //   car.carId = 100;
  //   car.Model = 'civic';
  //   car.color = 'white';
  //   car.Year = 2014;
  //   car.Rate = 100000;
  //   car.Manufacture = 'Honda';
  //   car.Type = 'hatchback';
  //   car.Sale = 'Y';

  //   cars.push(car);
  // }

}
