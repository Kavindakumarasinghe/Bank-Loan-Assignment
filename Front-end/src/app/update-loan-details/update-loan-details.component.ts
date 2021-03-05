import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoandetailService } from '../loandetail.service';
import { Loandetails } from '../loandetails';

@Component({
  selector: 'app-update-loan-details',
  templateUrl: './update-loan-details.component.html',
  styleUrls: ['./update-loan-details.component.css']
})
export class UpdateLoanDetailsComponent implements OnInit {


  loanDetailsId!: number;
  loandetails:Loandetails = new Loandetails();
 
  constructor(private loanDetailService : LoandetailService,
    private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.loanDetailsId= this.route.snapshot.params['loanDetailsId'];
    this.loanDetailService.getLoanDetailsById(this.loanDetailsId).subscribe(data =>{
      this.loandetails = data;
    },
    error =>console.log(error));
  }
  onSubmit(){
    this.loanDetailService.updateLoanDetails(this.loanDetailsId,this.loandetails).subscribe(data =>{
      this.goToLoanDetailList();
    });

  }
 
  
  goToLoanDetailList(){
    this.router.navigate(['/loandetails']);
  }
}
