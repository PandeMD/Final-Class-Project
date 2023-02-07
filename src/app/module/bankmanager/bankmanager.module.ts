import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SanctionletterComponent } from './sanctionletter/sanctionletter.component';
import { ApplicantlistComponent } from './applicantlist/applicantlist.component';
import { RouterModule, Routes } from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgxPaginationModule} from 'ngx-pagination';
import { DefaulterlistComponent } from './defaulterlist/defaulterlist.component';

const bmrouting:Routes=[
{path:'alist',component:ApplicantlistComponent},
{path:'sletter',component:SanctionletterComponent},
{path:'def',component:DefaulterlistComponent}
];

@NgModule({
  declarations: [
    ApplicantlistComponent,
    SanctionletterComponent,
    DefaulterlistComponent
  ],
  imports: [
    CommonModule,RouterModule.forChild(bmrouting),NgbModule,NgxPaginationModule
  ]
})
export class BankmanagerModule { }
