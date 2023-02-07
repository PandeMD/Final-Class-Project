import { Location } from '@angular/common';
import { Component, ElementRef, EventEmitter, Output, Renderer2, ViewChild } from '@angular/core';
import { Router} from '@angular/router';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  @Output() sideNavToggled=new EventEmitter<boolean>();
  menuStatus:boolean=false;
 
   constructor(private route:Router) { }
 
   ngOnInit(): void {
   }

   SideNavToggled(){
     this.menuStatus=!this.menuStatus;
     this.sideNavToggled.emit(this.menuStatus);
   }

   logout(){
     this.route.navigate(['login']);
   }
   
   emi(){
     this.route.navigate(['emidet']);
   }
   
}
