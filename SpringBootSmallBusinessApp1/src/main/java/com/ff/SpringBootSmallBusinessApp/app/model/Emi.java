package com.ff.SpringBootSmallBusinessApp.app.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@Getter
//@Setter
@Entity
public class Emi 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emiCalId;	
	private Integer emiNumber;
	private LocalDate emiDate;
	private String emiStatus;
	private double emiAmount;
	private double emiPaid;
	private Integer emiDetailId;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="emiId")
//	private EmiDetail ed;

}