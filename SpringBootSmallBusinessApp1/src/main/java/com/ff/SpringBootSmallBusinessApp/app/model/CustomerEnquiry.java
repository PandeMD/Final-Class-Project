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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerEnquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private Long mobileNumber;
	private String emailAddress;
	private String panNumber;
	@OneToOne(cascade = CascadeType.ALL)
	private CibilScore cibilscore;
}