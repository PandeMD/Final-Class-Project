import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
// import { MAT_MOMENT_DATE_ADAPTER_OPTIONS } from '@angular/material-moment-adapter';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CommonService } from 'src/app/shared/common.service';

@Component({
  selector: 'app-customerform',
  templateUrl: './customerform.component.html',
  styleUrls: ['./customerform.component.css'],
  providers: [
    // { provide: MAT_MOMENT_DATE_ADAPTER_OPTIONS, useValue: { useUtc: false } },
    // { provide: MAT_MOMENT_DATE_ADAPTER_OPTIONS, useValue: { strict: true } }
  ]
})
export class CustomerformComponent implements OnInit {
  title = "AngularApp";

  customer: Customer[]

  registrationForm: FormGroup

  selectedfile1: any
  selectedfile2: any
  selectedfile3: any
  selectedfile4: any
  selectedfile5: any
  selectedfile6: any
  selectedfile7: any
  selectedfile8: any
  selectedfile9: any

  selectedpanCard: any;
  selectedaadhaarCard: any;
  selectedphotoCopy: any;
  selectedbankStatement: any;
  selectedregistrationProof: any;
  selectedaddressProof: any;
  selectedsignature: any;
  selectedblankCheque: any;
  selecteditrCopy: any;

  isEditable = true;

  constructor(private commonService: CommonService, private _formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {

    this.registrationForm = new FormGroup({
      customerId: new FormControl(''),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      dateOfBirth: new FormControl('', Validators.required),
      gender: new FormControl('', Validators.required),
      maritialStatus: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required),
      mobileNumber: new FormControl('', Validators.required),
      emailAddress: new FormControl('', Validators.required),
      panNumber: new FormControl('', Validators.required),
      aadhaarNumber: new FormControl('', Validators.required),
      loanAmount: new FormControl('', Validators.required),
      businessTurnover: new FormControl('', Validators.required),
      monthlySales: new FormControl('', Validators.required),
      companyDetails: new FormGroup({
        companyId: new FormControl(''),
        companyName: new FormControl('', Validators.required),
        companyType: new FormControl('', Validators.required),
        monthlySales: new FormControl('', Validators.required),
        annualSales: new FormControl('', Validators.required),
        companyTurnover: new FormControl('', Validators.required),
        companyVintage: new FormControl('', Validators.required),
      }),
      bankDetails: new FormGroup({
        bankId: new FormControl(''),
        bankName: new FormControl('', Validators.required),
        accountNumber: new FormControl('', Validators.required),
        ifscCode: new FormControl('', Validators.required)
      }),
      loanRequest: new FormGroup({
        requestLoanId: new FormControl(''),
        requestLoanAmount: new FormControl('', Validators.required),
        requestLoanTenure: new FormControl('', Validators.required),
        requestLoanEmi: new FormControl('', Validators.required),
        sanctionStatus: new FormControl('', Validators.required),
        disbursalStatus: new FormControl('', Validators.required),
      }),
      previousLoan: new FormGroup({
        previousLoanId: new FormControl(''),
        loanAmount: new FormControl('', Validators.required),
        loanTenure: new FormControl('', Validators.required),
        paidAmount: new FormControl('', Validators.required),
        remainingAmount: new FormControl('', Validators.required),
        emiStatus: new FormControl('', Validators.required),
      }),
      guarantorDetails: new FormGroup({
        guarantorId: new FormControl(''),
        guarantorName: new FormControl('', Validators.required),
        guarantorRelation: new FormControl('', Validators.required),
        guarantorMobileNumber: new FormControl('', Validators.required),
        guarantorDesignation: new FormControl('', Validators.required)
      }),
      documentUpload: new FormGroup({
        documentId: new FormControl(''),
      })
    })

  }

  onselectedFile1(event: any) {

    this.selectedfile1 = event.target.files;
    this.selectedpanCard = event.target.files[0];
  }

  onselectedFile2(event: any) {

    this.selectedfile2 = event.target.files;
    this.selectedaadhaarCard = event.target.files[0];
  }

  onselectedFile3(event: any) {

    this.selectedfile3 = event.target.files;
    this.selectedphotoCopy = event.target.files[0];
  }

  onselectedFile4(event: any) {

    this.selectedfile4 = event.target.files;
    this.selectedbankStatement = event.target.files[0];
  }

  onselectedFile5(event: any) {

    this.selectedfile5 = event.target.files;
    this.selectedregistrationProof = event.target.files[0];
  }

  onselectedFile6(event: any) {

    this.selectedfile6 = event.target.files;
    this.selectedaddressProof = event.target.files[0];
  }

  onselectedFile7(event: any) {

    this.selectedfile7 = event.target.files;
    this.selectedsignature = event.target.files[0];
  }

  onselectedFile8(event: any) {

    this.selectedfile8 = event.target.files;
    this.selectedblankCheque = event.target.files[0];
  }

  onselectedFile9(event: any) {

    this.selectedfile9 = event.target.files;
    this.selecteditrCopy = event.target.files[0];
  }

  onSubmit() {

    const customerData = JSON.stringify(this.registrationForm.value)

    const uploadDocument = new FormData()

    uploadDocument.append("pancard", this.selectedpanCard)
    uploadDocument.append("aadhaarcard", this.selectedaadhaarCard)
    uploadDocument.append("photocopy", this.selectedphotoCopy)
    uploadDocument.append("bankstatement", this.selectedbankStatement)
    uploadDocument.append("registrationproof", this.selectedregistrationProof)
    uploadDocument.append("addressproof", this.selectedaddressProof)
    uploadDocument.append("signature", this.selectedsignature)
    uploadDocument.append("blankcheque", this.selectedblankCheque)
    uploadDocument.append("itrcopy", this.selecteditrCopy)
    uploadDocument.append("customer", customerData)

    alert("uploaded")

    // this.registrationForm.controls['firstName'].value
    // this.registrationForm.controls['lastName'].value
    // this.registrationForm.controls['dateOfBirth'].value
    // this.registrationForm.controls['address'].value
    // this.registrationForm.controls['emailAddress'].value
    // this.registrationForm.controls['panNumber'].value
    // this.registrationForm.controls['aadhaarNumber'].value
    // this.registrationForm.controls['gender'].value
    // this.registrationForm.controls['maritialStatus'].value
    // this.registrationForm.controls['loanAmount'].value
    // this.registrationForm.controls['businessTurnover'].value

    console.log(this.registrationForm.value)

    this.commonService.saveCustomer(uploadDocument).subscribe()
    alert("Customer registration done successfully")
   
    this.router.navigate(['role/RE/new-enquiry'])

  }

  // resetForm() {
  //   this.registrationForm.get('documentUpload').reset();

  // }

  resetSelectedFiles() {
    this.selectedfile1 = null;
    this.selectedfile2 = null;
    this.selectedfile3 = null;
    this.selectedfile4 = null;
    this.selectedfile5 = null;
    this.selectedfile6 = null;
  }

  // @ViewChild('fileUploader') fileUploader: ElementRef;

  // resetFileUploader() {
  //   this.fileUploader.nativeElement.value = null;
  // }
}


