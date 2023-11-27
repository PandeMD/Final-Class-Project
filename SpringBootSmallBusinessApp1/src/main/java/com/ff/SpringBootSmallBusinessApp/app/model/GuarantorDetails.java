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
public class GuarantorDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer guarantorId;
	private String guarantorName;
	private String guarantorRelation;
	private Long guarantorMobileNumber;
	private String guarantorDesignation;

}
