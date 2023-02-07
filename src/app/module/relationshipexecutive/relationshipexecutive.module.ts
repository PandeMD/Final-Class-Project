import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerformComponent } from './customerform/customerform.component';
import { RouterModule, Routes } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatStepperModule } from '@angular/material/stepper';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatCommonModule } from '@angular/material/core';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { NgxPaginationModule } from 'ngx-pagination';
import { NewEnquiryComponent } from './new-enquiry/new-enquiry.component';
import { ViewEnquiryComponent } from './view-enquiry/view-enquiry.component';

const rerouting: Routes = [
  { path: '', component: NewEnquiryComponent },
  { path: 'new-enquiry', component: NewEnquiryComponent },
  { path: 'view-enquiry', component: ViewEnquiryComponent },
  { path: 'register', component: CustomerformComponent }
]

@NgModule({
  declarations: [
    CustomerformComponent,
    NewEnquiryComponent,
    ViewEnquiryComponent
  ],
  imports: [
    RouterModule.forChild(rerouting),
    CommonModule,
    MatStepperModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCommonModule,
    MatCardModule,
    MatCheckboxModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule
  ],
  exports: [
    CustomerformComponent,
    ViewEnquiryComponent,
    NewEnquiryComponent
  ]
})
export class RelationshipexecutiveModule { }
