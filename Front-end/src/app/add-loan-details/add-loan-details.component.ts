import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoandetailService } from '../loandetail.service';
import { Loandetails } from '../loandetails';
import { LoandetailsListComponent } from '../loandetails-list/loandetails-list.component';

@Component({
  selector: 'app-add-loan-details',
  templateUrl: './add-loan-details.component.html',
  styleUrls: ['./add-loan-details.component.css']
})
export class AddLoanDetailsComponent implements OnInit {

  loandetails:Loandetails = new Loandetails();
  constructor(private loanDetailService : LoandetailService,
    private router:Router) { }
  
  ngOnInit(): void {
  }

  saveLoanDetails(){
    this.loanDetailService.addLoanDetails(this.loandetails).subscribe(data =>{
      console.log(data);
      this.goToLoanDetailList()
    },
    error => console.log(error));

    
  }
  goToLoanDetailList(){
    this.router.navigate(['/loandetails']);
  }

  onSubmit(){

    this.saveLoanDetails();

  }

}
