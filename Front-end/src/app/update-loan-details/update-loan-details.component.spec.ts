import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateLoanDetailsComponent } from './update-loan-details.component';

describe('UpdateLoanDetailsComponent', () => {
  let component: UpdateLoanDetailsComponent;
  let fixture: ComponentFixture<UpdateLoanDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateLoanDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateLoanDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
