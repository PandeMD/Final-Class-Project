import { Location } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Emi } from 'src/app/model/emi';
import { EmiDetail } from 'src/app/model/emi-detail';
import { LoanSanction } from 'src/app/model/loan-sanction';
import { CommonService } from 'src/app/shared/common.service';

@Component({
  selector: 'app-defaulterlist',
  templateUrl: './defaulterlist.component.html',
  styleUrls: ['./defaulterlist.component.css']
})
export class DefaulterlistComponent {

  page: number = 1;
  totalRecords: number;

  constructor(private fb:FormBuilder,private cs:CommonService,private location:Location,private http:HttpClient){}

  EmiList:EmiDetail[];

  Emil:EmiDetail={
    emiId: 0,
    emiTenure: 0,
    defaulterCount: 0,
    emiPreStatus: '',
    emiPaid: '',
    emiTotalAmount: 0,
    emiRoi: 0,
    ls: new LoanSanction,
    emi: new Emi
   
  }

  ngOnInit()
  {
    // this.cs.getDefaulterList(id,status).subscribe((List:EmiDetail)=>{
    //       this.Emil=List
    //     });

        // window.open("http://localhost:9090/api/defaultdetail/"+id+"/"+status);

        // this.get(this.Emil.emiId,this.Emil.emiPreStatus);

        
  }

  // get(_emiId: number,_emiPreStatus: string)
  // {

  //   this.cs.getDefaulterList(_emiId,_emiPreStatus).subscribe((List:EmiDetail)=>{
  //           this.Emil=List
  //         });
  // }

  Regular()
  {
    this.cs.getDefaulterList("Regular").subscribe((List:EmiDetail[])=>{
      this.EmiList=List
    });

  }

  Defaulter()
  {
    this.cs.getDefaulterList("Defaulter").subscribe((List:EmiDetail[])=>{
      this.EmiList=List
    });
  }

  Irregular()
  {
    this.cs.getDefaulterList("Irregular").subscribe((List:EmiDetail[])=>{
      this.EmiList=List
    });
  }
 
  getBack()
  {
    this.location.back();
  }

  sendMail() {

    const emailId = 'maithilipande65@gmail.com';
    let subject = '';
    // let textBody = '';
    let textBody = `Dear Customer,\n\n`; 
      subject = 'Notice for non-repayment of loan EMIs';
      textBody += 'This is to inform you that as you are not paying EMIs regularly for the loan amount sanctioned by our company. We hereby serving you the legal notice through email from our finance company. You are asked to reply and visit our company office at the earliest.\n\n Failing to do so will further lead to more legal actions by law.'
    
      this.cs.sendMailNotice(emailId, subject, textBody).subscribe(() => {
      console.log('Email sent successfully');
    });

    alert("Email sent successfully");

  }



}
