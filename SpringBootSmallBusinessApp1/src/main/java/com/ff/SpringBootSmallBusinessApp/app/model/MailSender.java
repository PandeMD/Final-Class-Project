package com.ff.SpringBootSmallBusinessApp.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailSender {

	
	private String toEmail;
	
	private String fromEmail;
	
	private String emailSubject;
	
	private String emailBody;
	
}
