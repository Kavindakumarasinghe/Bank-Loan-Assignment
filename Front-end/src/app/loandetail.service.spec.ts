import { TestBed } from '@angular/core/testing';

import { LoandetailService } from './loandetail.service';

describe('LoandetailService', () => {
  let service: LoandetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoandetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
