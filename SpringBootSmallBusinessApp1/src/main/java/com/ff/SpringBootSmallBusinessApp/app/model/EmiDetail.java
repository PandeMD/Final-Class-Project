package com.ff.SpringBootSmallBusinessApp.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmiDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emiId;
	private Integer emiTenure;
	private Integer defaulterCount;
	private String emiPreStatus;
	private Double emiTotalAmount;
	private Double emiRoi;
	@OneToOne(cascade = CascadeType.ALL)
	private LoanSanction ls;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Emi> emi=new HashSet<>();
	
}