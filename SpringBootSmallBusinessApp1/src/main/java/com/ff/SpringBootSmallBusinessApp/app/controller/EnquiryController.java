package com.ff.SpringBootSmallBusinessApp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.SpringBootSmallBusinessApp.app.model.CustomerEnquiry;
import com.ff.SpringBootSmallBusinessApp.app.service.EnquiryService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class EnquiryController {

	@Autowired
	EnquiryService es;

	// EnquiryAPI
	@GetMapping(value = "/getAllEnquiry")
	public ResponseEntity<Iterable<CustomerEnquiry>> getAllEnquiryData() {
		Iterable<CustomerEnquiry> elist = es.displayEnquiry();
		return new ResponseEntity<Iterable<CustomerEnquiry>>(elist, HttpStatus.OK);
	}

	@GetMapping(value = "/findEnquiryById/{enquiryId}")
	public ResponseEntity<CustomerEnquiry> findEnquiryById(@PathVariable("enquiryId") int enquiryId) {
		CustomerEnquiry ce = es.findEnquiryById(enquiryId);
		return new ResponseEntity<CustomerEnquiry>(ce, HttpStatus.OK);
	}

	@PostMapping(value = "/saveEnquiry")
	public ResponseEntity<Iterable<CustomerEnquiry>> customerEnquiry(@RequestBody CustomerEnquiry e) {

		/*
		 * CibilScore cibiLscore = new CibilScore();
		 * cibiLscore.setCibilId(e.getCibilscore().getCibilId());
		 * cibiLscore.setCibilScore(e.getCibilscore().getCibilScore());
		 * cibiLscore.setCibilStatus(e.getCibilscore().getCibilStatus());
		 * 
		 * CustomerEnquiry customerEnquiry = new CustomerEnquiry();
		 * customerEnquiry.setEnquiryId(e.getEnquiryId());
		 * customerEnquiry.setFirstName(e.getFirstName());
		 * customerEnquiry.setLastName(e.getLastName());
		 * customerEnquiry.setDateOfBirth(e.getDateOfBirth());
		 * customerEnquiry.setEmailAddress(e.getEmailAddress());
		 * customerEnquiry.setMobileNumber(e.getMobileNumber());
		 * customerEnquiry.setPanNumber(e.getPanNumber());
		 * customerEnquiry.setCibilscore(cibiLscore);
		 */

		es.saveEnquiry(e);
		Iterable<CustomerEnquiry> elist = es.displayEnquiry();
		return new ResponseEntity<Iterable<CustomerEnquiry>>(elist, HttpStatus.CREATED);
	}

	@GetMapping(value = "/cibil/{enquiryId}")
	public ResponseEntity<Integer> findCibil(@PathVariable(value = "enquiryId", required = true) Integer enquiryId) {
		System.out.println("in controller class" + enquiryId);
		Integer cibilScore = es.getCibil(enquiryId);
		return new ResponseEntity<Integer>(cibilScore, HttpStatus.OK);
	}
}