package com.ff.SpringBootSmallBusinessApp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	
//	{
//		"firstName":"Rupali",
//		"lastName":"Kale",
//		"password":"admin",
//		"role":"Relationship Execative",
//		"emailId":"rupa56@yahoo.com",
//		"dateOfBirth":"14/6/89",
//		"gender":"Female"
//	}
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer adminId;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	private String emailId;
	private String dateOfBirth;
	private String gender;
	@Lob
	private byte[] profilePhoto;
	

}
