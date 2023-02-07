import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/shared/common.service';

@Component({
  selector: 'app-new-enquiry',
  templateUrl: './new-enquiry.component.html',
  styleUrls: ['./new-enquiry.component.css']
})
export class NewEnquiryComponent {

  enquiryForm!: FormGroup;
  constructor(private _fb: FormBuilder, private commonService: CommonService, private router: Router) { }

  ngOnInit(): void {
    this.enquiryForm = this._fb.group(
      {
        enquiryId: [''],
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        dateOfBirth: ['', Validators.required],
        mobileNumber: ['', Validators.required],
        emailAddress: ['', Validators.required],
        panNumber: ['', Validators.required],
        cibilscore: this._fb.group({
          cibilId: [''],
          cibilScore: ['', Validators.required],
          cibilStatus: ['', Validators.required]
        })
      }
    )
  }
  onSubmit() {
    // if (this.enquiryForm.valid) {
      alert("Data Save");
    console.log(this.enquiryForm.value);
    this.commonService.saveEnquiry(this.enquiryForm.value).subscribe();
    window.location.reload()
  }

  back() {
    this.router.navigate(["/login"])
  }

  resetForm() {
    this.enquiryForm.reset()
  }
}


