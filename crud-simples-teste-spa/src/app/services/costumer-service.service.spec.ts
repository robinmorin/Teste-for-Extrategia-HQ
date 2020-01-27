import { TestBed } from '@angular/core/testing';

import { CostumerServiceService } from './costumer-service.service';

describe('CostumerServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CostumerServiceService = TestBed.get(CostumerServiceService);
    expect(service).toBeTruthy();
  });
});
