import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Customer } from 'src/app/model/customer';
import { EmiDetail } from 'src/app/model/emi-detail';
import { LoanSanction } from 'src/app/model/loan-sanction';
import { CommonService } from 'src/app/shared/common.service';


@Component({
  selector: 'app-loansanction',
  templateUrl: './loansanction.component.html',
  styleUrls: ['./loansanction.component.css']
})
export class LoansanctionComponent {

  page: number = 1;
  totalRecords: number;

  constructor(private fb:FormBuilder,private cs:CommonService,private location:Location){}

  EmiList:EmiDetail[];

  customerList: Customer[];

  ngOnInit()
  {
    this.cs.getEmi().subscribe((List:EmiDetail[])=>this.EmiList=List);

    this.cs.getCustomer().subscribe(data => {

      this.customerList = data;
    })
  }

  getBack()
  {
    this.location.back();
  }

}
