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

public class CompanyDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer companyId;
	
	private String companyName;
	
	private String companyType;
	
	private Double monthlySales;
	
	private Double annualSales;
	
	private Double companyTurnover;
	
	private Integer companyVintage;
	}
