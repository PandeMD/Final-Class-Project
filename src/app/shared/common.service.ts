import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../model/admin';
import { BankDetails } from '../model/bank-details';
import { CompanyDetails } from '../model/company-details';
import { Customer } from '../model/customer';
import { CustomerEnquiry } from '../model/customer-enquiry';
import { DocumentUpload } from '../model/document-upload';
import { Emi } from '../model/emi';
import { EmiDetail } from '../model/emi-detail';
import { GuarantorDetails } from '../model/guarantor-details';
import { LoanRequest } from '../model/loan-request';
import { PreviousLoan } from '../model/previous-loan';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private httpClient: HttpClient) { }

  //Customer Reigstration

  customerPostUrl: string = "http://localhost:9090/api/customer";
  customerGetUrl: string = "http://localhost:9090/api/get-customer";
  customerGetByIdUrl: string = "http://localhost:9090/api/get-customer-by-id";
  url1: string = "http://localhost:9090/api"


  //Customer Enquiry

  enquiryFindCibilUrl: string = "http://localhost:9090/api/cibil";
  enquiryGetSingleUrl: string = "http://localhost:9090/api/findEnquiryById";


  //EMi Detail

  url:string="http://localhost:9090/api/detail";  //EMI

  AllSaveEmi:string="http://localhost:9090/api/alldetail"

  AllUpdateEmi:string="http://localhost:9090/api/detail/"

  SingleGetEmi:string="http://localhost:9090/api/detail"

  defaulter:string="http://localhost:9090/api/defaultdetail";

  //Emi

  UpdateEmiMany:string="http://localhost:9090/api/emidetail/"

  Emiget:string="http://localhost:9090/api/emidetail";

  //Document Upload

  documentGetByIdUrl:string="http://localhost:9090/api/get-document";

  //Admin

  AdminUrl:string="http://localhost:9090/api/admin";

  AdminPostUrl:string="http://localhost:9090/api/saveadmin";

  // Mail

  emailUrl:string="http://localhost:9090/api/sendemailforlowcibil";

  emailUrlDis:string="http://localhost:9090/api/sendemailfordisburse";

  emailUrlFail:string="http://localhost:9090/api/sendemailforfail";

  emailUrlVarify:string="http://localhost:9090/api/sendemailforvarified";

  emailUrlNotice:string="http://localhost:9090/api/sendemailfornotice";


  //Relationship Executive --> Customer
  saveCustomer(Customer: any) {

    return this.httpClient.post<Customer>(this.customerPostUrl, Customer)

  }

  getCustomer(): Observable<Customer[]> {

    return this.httpClient.get<Customer[]>(this.customerGetUrl);
  }

  getCustomerById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(this.customerGetByIdUrl + "/" + id);
  }

  //Relationship Executive --> Customer Enquiry Form

  getEnquiryList(): Observable<CustomerEnquiry[]> {

    return this.httpClient.get<CustomerEnquiry[]>(this.url1 + "/getAllEnquiry");
  }
  saveEnquiry(cte: CustomerEnquiry): Observable<CustomerEnquiry> {
    // console.log(cte.enquiryId);
    return this.httpClient.post<CustomerEnquiry>(this.url1 + "/saveEnquiry", cte);
  }

  getEnquiryById(enquiryId: number): Observable<CustomerEnquiry> {
    return this.httpClient.get<CustomerEnquiry>(this.enquiryGetSingleUrl + "/" + enquiryId);
  }

  //Operational Executive --> Cibil Validation Form

  findCibil(enquiryId: number) {
    console.log("findCibil");
    return this.httpClient.get(this.enquiryFindCibilUrl + "/" + enquiryId);
  }

//Finance Head----> Emi Detail
  getEmi():Observable<EmiDetail[]>
  {
    return this.httpClient.get<EmiDetail[]>(this.url);
  }

  getEmiId(id: number): Observable<EmiDetail> {
    return this.httpClient.get<EmiDetail>(this.SingleGetEmi + "/" + id);
  }

  saveEmi(emi:EmiDetail)
  {
    return this.httpClient.post(this.url,emi);
  }

  saveAllEmi(emi:EmiDetail[])
  {
    return this.httpClient.post(this.AllSaveEmi,emi);
  }

  UpdateAllEmi(id:number)
  {
    return this.httpClient.put(this.AllUpdateEmi+id,id);
  }

  getDefaulterList(status:string): Observable<EmiDetail[]> 
  {
    // console.log(id);
    console.log(status);
    return this.httpClient.get<EmiDetail[]>(this.defaulter +"/"+status);
  }

  // Finance Head-->Emi

  UpdateEmi(emi:Emi)
  {
    return this.httpClient.put(this.UpdateEmiMany+emi.emiCalId,emi);
  }

  getEmiMany():Observable<Emi[]>
  {
    return this.httpClient.get<Emi[]>(this.Emiget);
  }

  getEmiById(id: number): Observable<Emi> {
    return this.httpClient.get<Emi>(this.Emiget + "/" + id);
  }
  
  //Admin 
  saveDoc( Admin:any)
  {
    return this.httpClient.post(this.AdminPostUrl,Admin);
  }

  getDoc():Observable<Admin[]>
  {
    return this.httpClient.get<Admin[]>(this.AdminUrl);
  }

  // Document
  getDocumentById(id:number):Observable<DocumentUpload>
  {
    
    return this.httpClient.get<DocumentUpload>(this.documentGetByIdUrl + "/" + id);
  }

  // Mail
  sendMail(toEmail: string, subject: string, textBody: string): Observable<any> {
    return this.httpClient.post(this.emailUrl, { toEmail, subject, textBody });
  }

  sendMailDis(toEmail: string, subject: string, textBody: string): Observable<any> {
    return this.httpClient.post(this.emailUrlDis, { toEmail, subject, textBody });
  }

  sendMailVarify(toEmail: string, subject: string, textBody: string): Observable<any> {
    return this.httpClient.post(this.emailUrlVarify, { toEmail, subject, textBody });
  }

  sendMailFail(toEmail: string, subject: string, textBody: string): Observable<any> {
    return this.httpClient.post(this.emailUrlFail, { toEmail, subject, textBody });
  }

  sendMailNotice(toEmail: string, subject: string, textBody: string): Observable<any> {
    return this.httpClient.post(this. emailUrlNotice, { toEmail, subject, textBody });
  }

 



 
}
