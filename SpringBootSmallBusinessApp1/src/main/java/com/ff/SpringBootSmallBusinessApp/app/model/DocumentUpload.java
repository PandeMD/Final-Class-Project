package com.ff.SpringBootSmallBusinessApp.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DocumentUpload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "document_id")
	private Integer documentId;

	@Column(name = "pan_card")
    @Lob
	private byte[] pancard;
     
	@Column(name = "aadhaar_card")
	@Lob
	 private byte[] aadhaarCard;

	  
		@Column(name = "photo_copy")
		@Lob
		private byte[] photoCopy;

		@Column(name = "bank_statement")
		@Lob
		private byte[] bankStatement;

		
		@Column(name = "registration_proof")
		@Lob
		private byte[] registrationProof;
		
		
		@Column(name = "address_proof")
		@Lob
		private byte[] addressProof;
    

		@Column(name = "signature")
		@Lob
		private byte[] signature; 


		@Column(name = "blank_cheque")
		@Lob
		private byte[] blankCheque;

        
		@Column(name = "itr_copy")
		@Lob
		private byte[] itrCopy;


}

