package com.ff.SpringBootSmallBusinessApp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer requestLoanId;
	private Double requestLoanAmount;
	private Integer requestLoanTenure;
	private Double requestLoanEmi;
	private String sanctionStatus;
	private String disbursalStatus;

}
