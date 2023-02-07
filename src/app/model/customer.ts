import { BankDetails } from "./bank-details"
import { CompanyDetails } from "./company-details"
import { DocumentUpload } from "./document-upload"
import { GuarantorDetails } from "./guarantor-details"
import { LoanRequest } from "./loan-request"
import { PreviousLoan } from "./previous-loan"

export class Customer {

    customerId: number
    firstName: string
    lastName: string
    dateOfBirth: string
    gender: string
    maritialStatus: string
    address: string
    mobileNumber: number
    emailAddress: string
    panNumber: string
    aadhaarNumber: string
    loanAmount: number
    businessTurnover: string
    monthlySales: number
    
    companyDetails: CompanyDetails
    bankDetails: BankDetails
    loanRequest: LoanRequest
    previousLoan: PreviousLoan
    guarantorDetails: GuarantorDetails
    documentUpload: DocumentUpload
}
