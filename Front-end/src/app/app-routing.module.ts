import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddLoanDetailsComponent } from './add-loan-details/add-loan-details.component';
import { LoandetailsListComponent } from './loandetails-list/loandetails-list.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UpdateLoanDetailsComponent } from './update-loan-details/update-loan-details.component';

const routes: Routes = [
  {path:'',redirectTo:'login',pathMatch:'full'},
  {path:'login', component:LoginComponent},
  {path:'register', component:RegisterComponent},
  {path:'loandetails', component:LoandetailsListComponent},
  {path:'loandetails/addloandetails', component:AddLoanDetailsComponent},
  {path:'update-loan-details/:loanDetailsId', component:UpdateLoanDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
