package com.ff.SpringBootSmallBusinessApp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ff.SpringBootSmallBusinessApp.app.model.Admin;
import com.ff.SpringBootSmallBusinessApp.app.service.AdminService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AdminController 
{
	@Autowired
	AdminService as;
	
	@PostMapping(value = "/saveadmin", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Admin> saveAdmin(@RequestPart(required = true, value = "admin") String admin,
			@RequestPart(required = true, value = "profilePhoto") MultipartFile profilePhoto)
	{
			ObjectMapper om=new ObjectMapper();
			try 
			{
				Admin a=om.readValue(admin, Admin.class);
				
				Admin adm=new Admin();
				
				adm.setFirstName(a.getFirstName());
				adm.setLastName(a.getLastName());
				adm.setDateOfBirth(a.getDateOfBirth());
				adm.setEmailId(a.getEmailId());
				adm.setGender(a.getGender());
				adm.setPassword(a.getPassword());
				adm.setRole(a.getRole());
				adm.setProfilePhoto(profilePhoto.getBytes());
				
				Admin admi=as.saveAdmin(adm);
				
				return new ResponseEntity<Admin>(admi,HttpStatus.CREATED);
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				return new ResponseEntity<Admin>(HttpStatus.BAD_REQUEST);
			}
			
	}
	
		@GetMapping(value = "/admin")
		public ResponseEntity<Iterable<Admin>> getAdmin()
		{
			Iterable<Admin> ad= as.getAdmin();
			
			return new ResponseEntity<Iterable<Admin>>(ad,HttpStatus.OK);
		}
	

}


