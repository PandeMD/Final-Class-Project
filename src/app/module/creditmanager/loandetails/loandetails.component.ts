import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Customer } from 'src/app/model/customer';
import { DocumentUpload } from 'src/app/model/document-upload';
import { LoanRequest } from 'src/app/model/loan-request';
import { CommonService } from 'src/app/shared/common.service';


@Component({
  selector: 'app-loandetails',
  templateUrl: './loandetails.component.html',
  styleUrls: ['./loandetails.component.css']
})
export class LoandetailsComponent {

   constructor(private cs:CommonService,private location:Location){}

   page: number = 1;
   totalRecords: number;

   customerList: Customer[]; 

  ngOnInit()
  {
    this.cs.getCustomer().subscribe((loanReqdata: Customer[]) => {
      this.customerList=loanReqdata;
      }) 

    this.cs.getCustomer().subscribe((Docdata: Customer[]) => {
    this.customerList=Docdata;
    })
  }

  docum:DocumentUpload={
    documentId: 0,
    pancard: [],
    aadhaarCard: [],
    photoCopy: [],
    bankStatement: [],
    registrationProof: [],
    addressProof: [],
    signature: [],
    blankCheque: [],
    itrCopy: []
  }
  
  Document(id:number)
  {
    this.cs.getDocumentById(id).subscribe((d:DocumentUpload)=>{
      alert(d.documentId)
      this.docum=d;
      
    })
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
      subject = 'Document rejection for Request for Loan';
      textBody += 'This letter is in reference to your loan application.\n\n It gives us the pain to describe to you that your request for the loan has been rejected by the board of directors of our finance company. After going through your application, it is found out that your documents are not proper or incomplete which could not met our criteria for sanctioning the loan. We are very sorry to inform you that your application was rejected due to above reason. Please visit our office for further details. Anyhow, we would always be obtainable to provide you with other matters.\n\n Hoping to serve you in a better way.'

    this.cs.sendMailFail(emailId, subject, textBody).subscribe(() => {
      console.log('Email sent successfully');
    });

    alert("Email sent successfully");

  }

  Verify()
  {
    alert("Document Varified");
  }
}
