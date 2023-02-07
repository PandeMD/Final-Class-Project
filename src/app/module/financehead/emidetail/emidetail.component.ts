import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup , Validators} from '@angular/forms';
import { BankDetails } from 'src/app/model/bank-details';
import { CompanyDetails } from 'src/app/model/company-details';
import { Customer } from 'src/app/model/customer';
import { DocumentUpload } from 'src/app/model/document-upload';
import { GuarantorDetails } from 'src/app/model/guarantor-details';
import { LoanRequest } from 'src/app/model/loan-request';
import { PreviousLoan } from 'src/app/model/previous-loan';
import { CommonService } from 'src/app/shared/common.service';


@Component({
  selector: 'app-emidetail',
  templateUrl: './emidetail.component.html',
  styleUrls: ['./emidetail.component.css']
})
export class EmidetailComponent {
 
  constructor(private fb:FormBuilder,private cs:CommonService,private location:Location){}

  emiForm=this.fb.group({
    emiId:[''],
    emiPreStatus:['', Validators.required],
    emiTotalAmount:['', Validators.required],
    emiTenure:['', Validators.required],
    emiPaid:['', Validators.required],
    emiRoi:['',Validators.required],
    defaulterCount:['', Validators.required],
    });

   loanSanction=this.fb.group({
      sanction_loan_id:[''],
      sanctionLoanAmount:['', Validators.required],
      sanctionLoanTenure:['', Validators.required],
      sanctionLoanEmi:['', Validators.required],
    }); 
    isOptional = false;

    emiForm1:FormGroup;

    customerList:Customer[];

  ngOnInit()
  {

    this.emiForm1=this.fb.group({
      emiId:[''],
      emiPreStatus:['', Validators.required],
      emiTotalAmount:['', Validators.required],
      emiTenure:['', Validators.required],
      emiPaid:['', Validators.required],
      emiRoi:['',Validators.required],
      defaulterCount:['', Validators.required],
      ls:this.fb.group({
        sanction_loan_id:[''],
        sanctionLoanAmount:['', Validators.required],
        sanctionLoanTenure:['', Validators.required],
        sanctionLoanEmi:['', Validators.required],
      }),
      });

    
    // this.detail=1;
  }

  CallBack()
  {
    alert("Data Save")
    console.log(this.emiForm1.value);

   
    // console.log("Emi Status: "+this.emiForm.get('emiStatus').value),
    // console.log("Emi Amount: "+this.emiForm.get('emiAmount').value),
    // console.log("Emi Tenure: "+this.emiForm.get('emiTenure').value),
    // console.log("Emi Paid: "+this.emiForm.get('emiPaid').value),
    // console.log("Sanction Loan Amount: "+this.emiForm.get('loanSanction').get('sanctionLoanAmount').value),
    // console.log("Sanction Loan Tenure: "+this.emiForm.get('loanSanction').get('sanctionLoanTenure').value),
    // console.log("Sanction Loan Emi: "+this.emiForm.get('loanSanction').get('sanctionLoanEmi').value)
    // console.log("Sanction Loan Amount: "+this.loanSanction.get('sanctionLoanAmount').value),
    // console.log("Sanction Loan Tenure: "+this.loanSanction.get('sanctionLoanTenure').value),
    // console.log("Sanction Loan Emi: "+this.loanSanction.get('sanctionLoanEmi').value)

// For Save Method:
    // this.emiForm1.get('emiStatus').setValue(this.emiForm.get('emiStatus').value),
    // this.emiForm1.get('emiAmount').setValue(this.emiForm.get('emiAmount').value),
    // this.emiForm1.get('emiTenure').setValue(this.emiForm.get('emiTenure').value),
    // this.emiForm1.get('emiPaid').setValue(this.emiForm.get('emiPaid').value),
    // this.emiForm1.get('defaulterCount').setValue(this.emiForm.get('defaulterCount').value),
    // this.emiForm1.get('ls').get('sanctionLoanAmount').setValue(this.loanSanction.get('sanctionLoanAmount').value),
    // this.emiForm1.get('ls').get('sanctionLoanTenure').setValue(this.loanSanction.get('sanctionLoanTenure').value),
    // this.emiForm1.get('ls').get('sanctionLoanEmi').setValue(this.loanSanction.get('sanctionLoanEmi').value),

    // console.log(this.emiForm1.value);

    this.cs.saveEmi(this.emiForm1.value).subscribe();
    // window.location.reload();

  }

  // next()
  // {
  //   this.detail++;
  // }

  // previous()
  // {
  //   this.detail--;
  // }

}
