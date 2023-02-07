import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmidetailComponent } from './emidetail/emidetail.component';
import { LoansanctionComponent } from './loansanction/loansanction.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatStepperModule} from '@angular/material/stepper';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import {NgxPaginationModule} from 'ngx-pagination';

const fhrouting:Routes=[
  {path:'emidet',component:EmidetailComponent},
  {path:'lsanction',component:LoansanctionComponent}
  ];

@NgModule({
  declarations: [
    EmidetailComponent,
    LoansanctionComponent, 
  ],
  imports: [
    CommonModule,RouterModule.forChild(fhrouting),
    FormsModule,
    ReactiveFormsModule,
    MatStepperModule,MatFormFieldModule,MatInputModule,MatOptionModule,MatSelectModule,NgxPaginationModule
  ]
})
export class FinanceheadModule { }



  
 