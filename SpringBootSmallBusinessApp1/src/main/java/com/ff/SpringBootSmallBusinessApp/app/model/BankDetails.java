package com.ff.SpringBootSmallBusinessApp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BankDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Integer bankId;
	
	private String bankName;
	
	private Long accountNumber;
	
	private String ifscCode;
	
}
