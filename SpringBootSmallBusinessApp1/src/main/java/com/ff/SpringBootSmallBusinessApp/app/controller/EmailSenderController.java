package com.ff.SpringBootSmallBusinessApp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.SpringBootSmallBusinessApp.app.model.EmailSender;
import com.ff.SpringBootSmallBusinessApp.app.service.EmailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmailSenderController 
{
	@Autowired
	EmailService es;

	@Value("${spring.mail.username}")
	private String fromEmail;

	// post API 

	@PostMapping(value = "/sendemailforlowcibil")
	public void sendEmail1(@RequestBody EmailSender sender) 
	{

		sender.setFromEmail(fromEmail);

		es.sendEmail(sender);
	}
	
	@PostMapping(value = "/sendemailforvarified")
	public void sendEmail2(@RequestBody EmailSender sender) 
	{

		sender.setFromEmail(fromEmail);

		es.sendEmail(sender);
	}
	
	@PostMapping(value = "/sendemailforfail")
	public void sendEmail3(@RequestBody EmailSender sender) 
	{

		sender.setFromEmail(fromEmail);

		es.sendEmail(sender);
	}
	
	@PostMapping(value = "/sendemailfordisburse")
	public void sendEmail4(@RequestBody EmailSender sender) 
	{

		sender.setFromEmail(fromEmail);

		es.sendEmail(sender);
	}
	
	@PostMapping(value = "/sendemailfornotice")
	public void sendEmail5(@RequestBody EmailSender sender) 
	{

		sender.setFromEmail(fromEmail);

		es.sendEmail(sender);
	}

	
}
