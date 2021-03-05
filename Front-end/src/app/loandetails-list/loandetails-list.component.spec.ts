import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoandetailsListComponent } from './loandetails-list.component';

describe('LoandetailsListComponent', () => {
  let component: LoandetailsListComponent;
  let fixture: ComponentFixture<LoandetailsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoandetailsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoandetailsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
