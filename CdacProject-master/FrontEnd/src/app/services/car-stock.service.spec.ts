import { TestBed } from '@angular/core/testing';

import { CarStockService } from './car-stock.service';

describe('CarStockService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CarStockService = TestBed.get(CarStockService);
    expect(service).toBeTruthy();
  });
});
