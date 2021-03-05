import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoandetailService } from '../loandetail.service';
import { Loandetails } from '../loandetails';

@Component({
  selector: 'app-loandetails-list',
  templateUrl: './loandetails-list.component.html',
  styleUrls: ['./loandetails-list.component.css']
})
export class LoandetailsListComponent implements OnInit {

  ldetails: Loandetails[] = [];
  
  constructor(private loandetailsService:LoandetailService,
    private router:Router) { }

  ngOnInit(): void {
    this.getLoanDetails();


  }
  private getLoanDetails(){
    this.loandetailsService.getLoanDetailsList().subscribe(data =>{
      this.ldetails = data;
    });
  } 
  updateLoanDetails(loanDetailsId:number){
    this.router.navigate(['update-loan-details',loanDetailsId]);
  }
  deleteLoanDetails(loanDetailsId:number){
    this.loandetailsService.deleteLoanDetails(loanDetailsId).subscribe(data =>{
      this.getLoanDetails();
    });

  }

}
