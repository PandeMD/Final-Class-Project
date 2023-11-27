package com.ff.SpringBootSmallBusinessApp.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String maritialStatus;
	private String address;
	private long mobileNumber;
	private String emailAddress;
	private String panNumber;
	private String aadhaarNumber;
	private Double loanAmount;
//	@Column(name = "business_turnover", columnDefinition = "varchar(100)")
	private String businessTurnover;
	private Double monthlySales;

	@OneToOne(cascade = CascadeType.ALL)
	private CompanyDetails companyDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private LoanRequest loanRequest;

	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoan previousLoan;

	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private DocumentUpload documentUpload;
}
