import { Component } from '@angular/core';
import { EmailValidator } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { CustomerEnquiry } from 'src/app/model/customer-enquiry';
import { CommonService } from 'src/app/shared/common.service';

@Component({
  selector: 'app-displayform',
  templateUrl: './displayform.component.html',
  styleUrls: ['./displayform.component.css']
})
export class DisplayformComponent {

  enquiryList: CustomerEnquiry[];
  page: number = 1;
  totalRecords: number;

  constructor(private commonService: CommonService, private router: Router) { }

  ngOnInit(): void {
      this.commonService.getEnquiryList().subscribe((data: CustomerEnquiry[]) => {
        this.enquiryList = data
      })
  }

  getBack() {

    this.router.navigate(["/enquiry"])
  }

  cibilScoreCheck(enquiryId: number) {
    console.log("cibilScoreCheck");
    this.commonService.findCibil(enquiryId).subscribe();
    window.location.reload();
  }

  // sendMail(cibilStatus: string) {

  //   const emailId = 'maithilipande65@gmail.com';
  //   const subject = 'CIBIL status information';
  //   let textBody = '';
  //   if (cibilStatus === 'Eligible') {
  //     textBody = 'Your CIBIL status is eligible';
  //   } else {
  //     textBody = 'Your CIBIL status is not eligible';
  //   }
  //   this.commonService.sendMail(emailId, subject, textBody).subscribe(() => {
  //     console.log('Email sent successfully');
  //   });

  //   alert("Email sent successfully")

  // }

  sendMail(cibilStatus: string, emailAddress: string, e: any) {

    const emailId = 'maithilipande65@gmail.com';
    let subject = '';
    // let textBody = '';
    let textBody = `Dear ${e.firstName},\n\n`; 
    if (cibilStatus === 'Eligible') {
      subject = 'LETTER OF ELIGIBILITY FOR LOAN REQUEST';
      textBody += 'This letter is in reference to your loan enquiry. \n\nAfter verification of your CIBIL it is found out your CIBIL score is meeting our criteria for sanctioning the loan. We would like to inform you that your loan enquiry is approved for the further process. Please visit to our office at the earliest. Anyhow, we would always be obtainable to provide you with other matters. \n\nHoping to serve you in a better way.\n\nRegards\nCredify And Team';
    } else {  
      subject = 'LETTER OF REJECTION FOR LOAN REQUEST DUE TO LOW CIBIL';
      textBody += 'This letter is in reference to your loan enquiry. \n\nIt gives us the pain to describe to you that your request for the loan of has been rejected by the board of directors of our finance company. After verification it is found out that your CIBIL could not met our criteria for sanctioning the loan. We are very sorry to inform you that your application was rejected due to above reason. Anyhow, we would always be obtainable to provide you with other matters. \n\nHoping to serve you in a better way.\n\nRegards\nCredify And Team';
    }
    this.commonService.sendMail(emailId, subject, textBody).subscribe(() => {
      console.log('Email sent successfully');
    });

    alert("Email sent successfully")

  }


}
