import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent {

  @Input() sideNavStatus:boolean=true;
  
  list=[
   {
    RE:[
      {path:"new-enquiry", title:"Enquiey Form", icon:"fa fa-file"},
      {path:"register", title:"CustomerForm", icon:"fa fa-file"},
      {path:"view-enquiry", title:"AllEnquiries", icon:"fa fa-list"}
      
      ],
      OE:[
        {path:"dform", title:"displayform", icon:"fa fa-file"}
      ],
      CM:[
        {path:"ldetail",title:"Loan Details",icon:"fa fa-list"}
      ],
      BM:[
        {path:"alist", title:"Applicant List", icon:"fa fa-list"},
        {path:"sletter", title:"Sanction Letter", icon:"fa fa-file"},
        {path:"def", title:"Defaulter List", icon:"fa fa-list"},
      ],
      FH:[
        {path:"emidet", title:"Emi Detail", icon:"fa fa-list"},
        {path:"lsanction", title:"Loan Sanction", icon:"fa fa-file"}
      ],
      Admin:[
        {path:"adlist",title:"Loan Details",icon:"fa fa-list"}
      ]

   }
  ];

  role:string;

  constructor() { }

  ngOnInit(): void {

    console.log(this.list);
    this.role=sessionStorage.getItem("role");

  }

}






