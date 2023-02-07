import { Emi } from "./emi";
import { LoanSanction } from "./loan-sanction";

export class EmiDetail 
{

    emiId:number;
    // firstName:string;
    // accountNumber:number;
    // emailAddress:string;
    emiTenure:number;
    defaulterCount:number;
    emiPreStatus:string;
    emiPaid:string;
    emiTotalAmount:number;
    emiRoi:number;
    ls:LoanSanction;
    emi:Emi;
   
}
