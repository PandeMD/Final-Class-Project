import { Component } from '@angular/core';
import { Router } from '@angular/router';

export interface user {
  username: string;
  password: string;
  repassword: string;
  email: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  u: user = {
    username: "",
    password: "",
    repassword: "",
    email: ""
  };

  constructor(private router: Router) {}

  username: string='';
  password:string='';

  ngOnInit() {}
  login(u:any) {
    console.log("login called");
    console.log(u.username,u.password);
    
    if (u.username === 're' && u.password === 're') {
      console.log('in admin');
      sessionStorage.setItem('role', 'RE');
      this.router.navigateByUrl("role/RE");
    }
    if (u.username === 'oe' && u.password === 'oe') {
     
      sessionStorage.setItem('role', 'OE');
      this.router.navigateByUrl("role/OE");
    }
    if (u.username === 'cm' && u.password === 'cm') {
     
      sessionStorage.setItem('role', 'CM');
      this.router.navigateByUrl("role/CM");
    }
    if (u.username === 'bm' && u.password === 'bm') {
      console.log(u.username,u.password);
      sessionStorage.setItem('role', 'BM');
      this.router.navigateByUrl("role/BM");
    }
    if (u.username === 'fh' && u.password === 'fh') {
      console.log('in admin');
      sessionStorage.setItem('role', 'FH');
      this.router.navigateByUrl("role/FH");
    }
    if (u.username === 'admin' && u.password === 'admin') {
      sessionStorage.setItem('role', 'Admin');
      this.router.navigateByUrl("role/Admin");
    }
    
  }
  signup(u:any) {
    console.log("signup");
  }

}


