import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminlistComponent } from './adminlist/adminlist.component';
import { Routes, RouterModule } from '@angular/router';
import {NgxPaginationModule} from 'ngx-pagination';
import { ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

const adrouting:Routes=[
 {path:'adlist',component:AdminlistComponent} 
];

@NgModule({
  declarations: [
    AdminlistComponent
  ],
  imports: [
    CommonModule,RouterModule.forChild(adrouting),
    NgxPaginationModule,
    ReactiveFormsModule,
    NgbModule
  ]
})
export class AdminModule { }
