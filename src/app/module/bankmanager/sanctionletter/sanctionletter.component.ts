import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Customer } from 'src/app/model/customer';
import { Emi } from 'src/app/model/emi';
import { EmiDetail } from 'src/app/model/emi-detail';
import { LoanSanction } from 'src/app/model/loan-sanction';
import { CommonService } from 'src/app/shared/common.service';


@Component({
  selector: 'app-sanctionletter',
  templateUrl: './sanctionletter.component.html',
  styleUrls: ['./sanctionletter.component.css']
})
export class SanctionletterComponent {

  page: number = 1;
  page1: number = 1;
  totalRecords: number;

  EmiList:EmiDetail[];

  ManyEmi:Emi[];

  customerList: Customer[]; 

  title = 'appBootstrap';
  
  closeResult: string;
  
  constructor(private modalService: NgbModal,private cs:CommonService,private location:Location,private router:Router) {}

  ngOnInit()
  {
    this.cs.getEmi().subscribe((List:EmiDetail[])=>this.EmiList=List);

    this.cs.getEmiMany().subscribe((List:Emi[])=>this.ManyEmi=List);

    this.cs.getCustomer().subscribe(data => {

      this.customerList = data;
    })
  }

  // StatusChange(emi:EmiDetail)
  // {
  //   console.log(emi.emiId);
  //   if(emi.emiId>0)
  //   {
  //     emi.emiStaus='Paid';
  //     this.cs.UpdateAllEmi(emi.emiId).subscribe();
  //   }
  //   console.log(emi.emiStaus);

  //   // this.cs.saveEmi(this.emiForm1.value).subscribe();
  // }

  // StatusUnpaidChange(emi:EmiDetail)
  // {
  //   console.log(emi.emiId);
  //   if(emi.emiId>0)
  //   {
  //     emi.emiStaus='Not Paid';
  //     // this.cs.UpdateAllEmi(emi.emiId).subscribe();
  //     this.cs.UpdateEmi(emi.emiId).subscribe();
  //   }
  //   console.log(emi.emiStaus);
  // }


  StatusChange(em:Emi)
  {
    console.log(em.emiCalId);
    if(em.emiCalId>0)
    {
      em.emiStatus='Paid';
      // this.cs.UpdateAllEmi(emi.emiId).subscribe();
      this.cs.UpdateEmi(em).subscribe();
      console.log(em.emiCalId);
    }
    console.log(em.emiStatus);
  }

  StatusUnpaidChange(em:Emi)
  {
    console.log(em.emiCalId);
    if(em.emiCalId>0)
    {
      em.emiStatus='NotPaid';
      // this.cs.UpdateAllEmi(emi.emiId).subscribe();
      this.cs.UpdateEmi(em).subscribe();
    }
    console.log(em.emiStatus);
  }

  save()
  {
     alert("Data Save")
    //  this.cs.saveAllEmi(this.EmiList).subscribe();
  }

  many:Emi={
    emiCalId: 0,
    emiNumber: 0,
    emiDate: undefined,
    emiStatus: '',
    emiAmount: 0,
    emiPaid: 0,
    emiDetailId: 0
  }

  detail:EmiDetail={
    emiId: 0,
    emiTenure: 0,
    defaulterCount: 0,
    emiPreStatus: '',
    emiTotalAmount: 0,
    emiRoi: 0,
    emiPaid: '',
    ls: new LoanSanction,
    emi: new Emi,
    
  }

  Popup(id:number)
  {
    // this.cs.getEmiById(id).subscribe((List:Emi)=>{
    //   alert(List.emiDetailId)
    //   this.many=List
    // });

    this.cs.getEmiId(id).subscribe((List:EmiDetail)=>{
        this.detail=List
      });
  }

  // Defaulter(id:number,status:string)
  // {
  //   console.log(id);
  //   console.log(status);
    
  //   this.cs.getDefaulterList(id,status).subscribe((List:EmiDetail)=>{
  //     this.detail=List
  //   });
  //   // this.router.navigate(["role/BM/def"]);
  // }
    
  open(content) {

    this.modalService.open(content, {ariaLabelledBy: 'myLargeModalLabel'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });

  }
  
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  getBack()
  {
    this.location.back();
  }

  Pdf(id:number)
  {
    window.open("http://localhost:9090/api/genPdf/"+id);
  } 

  Excel(id:number)
  {
    window.open("http://localhost:9090/api/excel/"+id);
  }


}
