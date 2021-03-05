import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Loandetails } from './loandetails';

@Injectable({
  providedIn: 'root'
})
export class LoandetailService {

  private baseURL = "http://localhost:8080/api/v1/loandetails";
  
  constructor(private httpClient:HttpClient) { }

     getLoanDetailsList():Observable<Loandetails[]>{
       return  this.httpClient.get<Loandetails[]>(`${this.baseURL}`);
     }

     addLoanDetails(loandetails:Loandetails):Observable<Object>{
       return this.httpClient.post(`${this.baseURL}`,loandetails);
     }

     getLoanDetailsById(loanDetailsId:number):Observable<Loandetails>{
       return this.httpClient.get<Loandetails>(`${this.baseURL}/${loanDetailsId}`);

     }

     updateLoanDetails(loanDetailsId: number,loandetails:Loandetails):Observable<Object>{
       return this.httpClient.put(`${this.baseURL}/${loanDetailsId}`,loandetails);

     }
     deleteLoanDetails(loanDetailsId:number):Observable<Object>{
       return this.httpClient.delete(`${this.baseURL}/${loanDetailsId}`);

     }
   
}

