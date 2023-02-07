import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerEnquiry } from 'src/app/model/customer-enquiry';
import { CommonService } from 'src/app/shared/common.service';


@Component({
  selector: 'app-view-enquiry',
  templateUrl: './view-enquiry.component.html',
  styleUrls: ['./view-enquiry.component.css']
})
export class ViewEnquiryComponent {

  enquiryList: CustomerEnquiry[];
  page: number = 1;
  totalRecords: number;

  constructor(private commonService: CommonService, private router: Router) { }

  ngOnInit(): void {

    {
      this.commonService.getEnquiryList().subscribe((data: CustomerEnquiry[]) => {
        this.enquiryList = data
      })

    }

  }

  register() {

      this.router.navigate(["role/RE/register"])
    }

  getBack() {

    this.router.navigate(["role/RE/new-enquiry"])
  }

  isEligible(cibilStatus: string): boolean {
    if (cibilStatus === 'Eligible') {
        return true;
    }
    return false;
}


}