import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoandetailsComponent } from './loandetails/loandetails.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatStepperModule} from '@angular/material/stepper';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import {NgxPaginationModule} from 'ngx-pagination';

const cmrouting:Routes=[
  {path:'ldetail',component:LoandetailsComponent}
  ];

@NgModule({
  declarations: [
    LoandetailsComponent,
  ],
  imports: [
    CommonModule,RouterModule.forChild(cmrouting),
    FormsModule,
    ReactiveFormsModule,
    MatStepperModule,MatFormFieldModule,MatInputModule,MatOptionModule,MatSelectModule,NgxPaginationModule
  ]
})
export class CreditmanagerModule { }
