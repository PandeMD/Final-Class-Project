import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Admin } from 'src/app/model/admin';
import { CommonService } from 'src/app/shared/common.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-adminlist',
  templateUrl: './adminlist.component.html',
  styleUrls: ['./adminlist.component.css']
})

export class AdminlistComponent {

  constructor(private modalService: NgbModal,private location:Location,private cs:CommonService,private fb:FormBuilder){}

  selectPhoto:any;

  EmpList:Admin[];

  EmpForm:FormGroup;

  page: number = 1;
  totalRecords: number;

  ngOnInit()
  {

    this.cs.getDoc().subscribe((List:Admin[])=>this.EmpList=List);

    this.EmpForm=this.fb.group({
      adminId:[''],
      firstName:['', Validators.required],
      lastName:['', Validators.required],
      password:['', Validators.required],
      role:['', Validators.required],
      emailId:['', Validators.required],
      dateOfBirth:['', Validators.required],
      gender:['', Validators.required],
    });

  }

  getBack()
  {
    this.location.back();
  }

  onSelectFile1(event:any)
  {
    this.selectPhoto=event.target.files[0];
  }

  saveEmp()
  {
    alert("Data Save")
    console.log(this.EmpForm.value);
    const adminData = JSON.stringify(this.EmpForm.value)
    
    let data=new FormData();
    data.append("profilePhoto",this.selectPhoto);
    data.append("admin",adminData);

    this.cs.saveDoc(data).subscribe();
  }

  title = 'appBootstrap';
  
  closeResult: string;

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
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

}
