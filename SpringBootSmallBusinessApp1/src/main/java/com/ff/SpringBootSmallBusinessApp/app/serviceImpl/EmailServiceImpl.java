package com.ff.SpringBootSmallBusinessApp.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ff.SpringBootSmallBusinessApp.app.model.EmailSender;
import com.ff.SpringBootSmallBusinessApp.app.service.EmailService;

@Component
public class EmailServiceImpl implements EmailService
{
	@Autowired
	JavaMailSender mailSender;

	@Override
	public void sendEmail(EmailSender sender) {
		
			SimpleMailMessage message=new SimpleMailMessage();
			message.setTo(sender.getToEmail());
			message.setFrom(sender.getFromEmail());
			message.setSubject(sender.getSubject());
			message.setText(sender.getTextBody());
			mailSender.send(message);
			System.out.println("email sent succesfully.");
			
		}
	

}
