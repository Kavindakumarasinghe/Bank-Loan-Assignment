import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
/*onSubmit(){
    this.router.navigate(['/loandetails']);
   
  }*/

  onLogin(){
    this.router.navigate(['/loandetails']);
  }
  onReg(){
    this.router.navigate(['/register']);
  }

}
