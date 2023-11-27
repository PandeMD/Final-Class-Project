package com.ff.SpringBootSmallBusinessApp.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "previous_loan_details")
public class PreviousLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "previous_loan_id")
	private Integer previousLoanId;
	@Column(name = "loan_amount")
    private Double loanAmount;
	@Column(name = "loan_tenure")
   private Integer loanTenure;
	@Column(name = "paid_amount")
	private Double paidAmount;
	@Column(name = "remaining_amount")
    private Double remainingAmount;
	@Column(name = "emi_status")
	private String emiStatus;

}
