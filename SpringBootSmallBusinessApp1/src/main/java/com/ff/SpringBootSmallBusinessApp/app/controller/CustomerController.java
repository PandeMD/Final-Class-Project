package com.ff.SpringBootSmallBusinessApp.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ff.SpringBootSmallBusinessApp.app.model.BankDetails;
import com.ff.SpringBootSmallBusinessApp.app.model.CompanyDetails;
import com.ff.SpringBootSmallBusinessApp.app.model.Customer;
import com.ff.SpringBootSmallBusinessApp.app.model.DocumentUpload;
import com.ff.SpringBootSmallBusinessApp.app.model.GuarantorDetails;
import com.ff.SpringBootSmallBusinessApp.app.model.LoanRequest;
import com.ff.SpringBootSmallBusinessApp.app.model.PreviousLoan;
import com.ff.SpringBootSmallBusinessApp.app.service.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping(value = "/customer", headers = ("content-type=multipart/*"), consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Customer> saveCustomer(@RequestPart(required = true, value = "pancard") MultipartFile pancard,
			@RequestPart(required = true, value = "aadhaarcard") MultipartFile aadhaarcard,
			@RequestPart(required = true, value = "photocopy") MultipartFile photocopy,
			@RequestPart(required = true, value = "bankstatement") MultipartFile bankstatement,
			@RequestPart(required = true, value = "registrationproof") MultipartFile registrationproof,
			@RequestPart(required = true, value = "addressproof") MultipartFile addressproof,
			@RequestPart(required = true, value = "signature") MultipartFile signature,
			@RequestPart(required = true, value = "blankcheque") MultipartFile blankcheque,
			@RequestPart(required = true, value = "itrcopy") MultipartFile itrcopy,
			@RequestPart(required = true, value = "customer") String customer) {

		ObjectMapper objectMapper = new ObjectMapper();
		try {

			DocumentUpload documentUpload = new DocumentUpload();
			documentUpload.setPancard(pancard.getBytes());
			documentUpload.setAadhaarCard(aadhaarcard.getBytes());
			documentUpload.setPhotoCopy(photocopy.getBytes());
			documentUpload.setBankStatement(bankstatement.getBytes());
			documentUpload.setRegistrationProof(registrationproof.getBytes());
			documentUpload.setAddressProof(addressproof.getBytes());
			documentUpload.setSignature(signature.getBytes());
			documentUpload.setBlankCheque(blankcheque.getBytes());
			documentUpload.setItrCopy(itrcopy.getBytes());

			Customer getCustomer = objectMapper.readValue(customer, Customer.class);

			String x = getCustomer.getDateOfBirth();

			System.out.println(x);

			String[] dob = x.split("T");

			Customer setCustomer = new Customer();
			setCustomer.setFirstName(getCustomer.getFirstName());
			setCustomer.setLastName(getCustomer.getLastName());
			setCustomer.setDateOfBirth(dob[0]);
			setCustomer.setGender(getCustomer.getGender());
			setCustomer.setMaritialStatus(getCustomer.getMaritialStatus());
			setCustomer.setAddress(getCustomer.getAddress());
			setCustomer.setMobileNumber(getCustomer.getMobileNumber());
			setCustomer.setEmailAddress(getCustomer.getEmailAddress());
			setCustomer.setPanNumber(getCustomer.getPanNumber());
			setCustomer.setAadhaarNumber(getCustomer.getAadhaarNumber());
			setCustomer.setLoanAmount(getCustomer.getLoanAmount());
			setCustomer.setBusinessTurnover(getCustomer.getBusinessTurnover());
			setCustomer.setMonthlySales(getCustomer.getMonthlySales());

			CompanyDetails companyDetails = new CompanyDetails();
			companyDetails.setCompanyName(getCustomer.getCompanyDetails().getCompanyName());
			companyDetails.setCompanyType(getCustomer.getCompanyDetails().getCompanyType());
			companyDetails.setMonthlySales(getCustomer.getCompanyDetails().getMonthlySales());
			companyDetails.setAnnualSales(getCustomer.getCompanyDetails().getAnnualSales());
			companyDetails.setCompanyTurnover(getCustomer.getCompanyDetails().getCompanyTurnover());
			companyDetails.setCompanyVintage(getCustomer.getCompanyDetails().getCompanyVintage());

			BankDetails bankDetails = new BankDetails();
			bankDetails.setBankName(getCustomer.getBankDetails().getBankName());
			bankDetails.setAccountNumber(getCustomer.getBankDetails().getAccountNumber());
			bankDetails.setIfscCode(getCustomer.getBankDetails().getIfscCode());

			LoanRequest loanRequest = new LoanRequest();
			loanRequest.setRequestLoanAmount(getCustomer.getLoanRequest().getRequestLoanAmount());
			loanRequest.setRequestLoanTenure(getCustomer.getLoanRequest().getRequestLoanTenure());
			loanRequest.setRequestLoanEmi(getCustomer.getLoanRequest().getRequestLoanEmi());
			loanRequest.setSanctionStatus(getCustomer.getLoanRequest().getSanctionStatus());
			loanRequest.setDisbursalStatus(getCustomer.getLoanRequest().getDisbursalStatus());

			PreviousLoan previousLoan = new PreviousLoan();
			previousLoan.setLoanAmount(getCustomer.getPreviousLoan().getLoanAmount());
			previousLoan.setLoanTenure(getCustomer.getPreviousLoan().getLoanTenure());
			previousLoan.setEmiStatus(getCustomer.getPreviousLoan().getEmiStatus());
			previousLoan.setPaidAmount(getCustomer.getPreviousLoan().getPaidAmount());
			previousLoan.setRemainingAmount(getCustomer.getPreviousLoan().getRemainingAmount());

			GuarantorDetails guarantorDetails = new GuarantorDetails();
			guarantorDetails.setGuarantorName(getCustomer.getGuarantorDetails().getGuarantorName());
			guarantorDetails.setGuarantorRelation(getCustomer.getGuarantorDetails().getGuarantorRelation());
			guarantorDetails.setGuarantorMobileNumber(getCustomer.getGuarantorDetails().getGuarantorMobileNumber());
			guarantorDetails.setGuarantorDesignation(getCustomer.getGuarantorDetails().getGuarantorDesignation());

			setCustomer.setCompanyDetails(companyDetails);
			setCustomer.setBankDetails(bankDetails);
			setCustomer.setLoanRequest(loanRequest);
			setCustomer.setPreviousLoan(previousLoan);
			setCustomer.setGuarantorDetails(guarantorDetails);
			setCustomer.setDocumentUpload(documentUpload);

			Customer saveCustomer = service.save(setCustomer);

			return new ResponseEntity<Customer>(saveCustomer, HttpStatus.CREATED);

		} catch (JsonProcessingException e) {

			e.printStackTrace();

			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		} catch (IOException e) {

			e.printStackTrace();

			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/get-customer")
	public ResponseEntity<List<Customer>> getAllCustomers() {

		List<Customer> customerlist = service.getAll();

		return new ResponseEntity<List<Customer>>(customerlist, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updatecustomer(@PathVariable("id") Integer customerId, @RequestBody Customer c) {
		Customer customer1 = service.findbyId(customerId);

		// customer1.setCustomerId(c.getCustomerId());
		customer1.setFirstName(c.getFirstName());
		customer1.setLastName(c.getLastName());
		customer1.setDateOfBirth(c.getDateOfBirth());
		customer1.setGender(c.getGender());
		customer1.setMaritialStatus(c.getMaritialStatus());
		customer1.setAddress(c.getAddress());
		customer1.setMobileNumber(c.getMobileNumber());
		customer1.setEmailAddress(c.getEmailAddress());
		customer1.setPanNumber(c.getPanNumber());
		customer1.setAadhaarNumber(c.getAadhaarNumber());
		customer1.setLoanAmount(c.getLoanAmount());
		customer1.setBusinessTurnover(c.getBusinessTurnover());
		customer1.setMonthlySales(c.getMonthlySales());

		service.save(customer1);

		return new ResponseEntity<Customer>(customer1, HttpStatus.OK);

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Customer> deletecustomer(@PathVariable("id") Integer customerId) {

		service.deletecustomer(customerId);

		return new ResponseEntity<Customer>(HttpStatus.OK);
	}

	@GetMapping(value = "/get-customer-by-id/{id}")
	public ResponseEntity<Customer> findSingleCustomer(@PathVariable("id") Integer customerId) {

		Customer customer = service.findbyId(customerId);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
