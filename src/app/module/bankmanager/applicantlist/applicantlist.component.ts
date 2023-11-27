import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Customer } from 'src/app/model/customer';
import { EmiDetail } from 'src/app/model/emi-detail';
import { CommonService } from 'src/app/shared/common.service';


@Component({
  selector: 'app-applicantlist',
  templateUrl: './applicantlist.component.html',
  styleUrls: ['./applicantlist.component.css']
})
export class ApplicantlistComponent {

  constructor(private cs:CommonService,private location:Location){}

  page: number = 1;
  totalRecords: number;
  customerList: Customer[]; 
  EmiList:EmiDetail[];

  ngOnInit()
  {
    this.cs.getCustomer().subscribe((custdata: Customer[]) => {
      this.customerList=custdata;
      }) 

      this.cs.getEmi().subscribe((List:EmiDetail[])=>this.EmiList=List);
  }   

  getBack()
  {
    this.location.back();
  }

  Disburse()
  {
    alert("Data Disburse");

    const emailId = 'maithilipande65@gmail.com';
    let subject = '';
    // let textBody = '';
    let textBody = `Dear Customer,\n\n`; 
      subject = 'Loan amount disbursement confirmation.';
      textBody += 'We are highly pleased to inform you that your application for a small business finance loan has been approved by our finance company. I hereby request you to please check your bank account for the credited loan amount from our finance company.\n\n For further details please visit our company office.\n\nRegards\nCredify And Team'
    this.cs.sendMailDis(emailId, subject, textBody).subscribe(() => {
      console.log('Email sent successfully');
    });

    alert("Email sent successfully");

  }


}
