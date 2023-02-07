import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DisplayformComponent } from './displayform/displayform.component';
import { Router, RouterModule, Routes } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';

const oprouting:Routes=[
  {path:'dform',component:DisplayformComponent}
]

@NgModule({
  declarations: [
    DisplayformComponent
  ],
  imports: [
    CommonModule,RouterModule.forChild(oprouting),
    NgxPaginationModule
  ]
})
export class OperationalexecutiveModule { }
