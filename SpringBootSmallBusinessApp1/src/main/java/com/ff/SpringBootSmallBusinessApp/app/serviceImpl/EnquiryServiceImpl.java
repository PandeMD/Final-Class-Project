package com.ff.SpringBootSmallBusinessApp.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.SpringBootSmallBusinessApp.app.exception.CustomerNotFoundException;
import com.ff.SpringBootSmallBusinessApp.app.model.CibilScore;
import com.ff.SpringBootSmallBusinessApp.app.model.CustomerEnquiry;
import com.ff.SpringBootSmallBusinessApp.app.repositary.EnquiryRepository;
import com.ff.SpringBootSmallBusinessApp.app.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryRepository er;

	@Override
	public CustomerEnquiry saveEnquiry(CustomerEnquiry e) {
		return er.save(e);
	}

	@Override
	public Iterable<CustomerEnquiry> displayEnquiry() {
		return er.findAll();
	}

	@Override
	public CustomerEnquiry findEnquiryById(Integer enquiryId) {
		Optional<CustomerEnquiry> op = er.findById(enquiryId);
		if (op.isPresent()) {
			CustomerEnquiry customerEnquiry = op.get();
			customerEnquiry.getCibilscore().setCibilStatus("Eligible");

			return customerEnquiry;
		} else {
			throw new CustomerNotFoundException("Customer record not found in database");
		}
	}

	@Override
	public Integer getCibil(Integer enquiryId) {
		Integer min = 600;
		Integer max = 900;
		Integer b = (int) (Math.random() * ((max - min + 1) + min));
		
		System.out.println("in service class" + enquiryId);
		
		System.out.println(b);

		if (b > 750) {
			Optional<CustomerEnquiry> op = er.findById(enquiryId);

			CustomerEnquiry customerEnquiry = op.get();

			System.out.println(customerEnquiry.getCibilscore().getCibilId());

			CibilScore c = new CibilScore();
			c.setCibilId(customerEnquiry.getCibilscore().getCibilId());
			c.setCibilScore(b);
			c.setCibilStatus("Eligible");

			customerEnquiry.setCibilscore(c);

			er.save(customerEnquiry);
			
			return b;
		} else {
			
			Optional<CustomerEnquiry> op = er.findById(enquiryId);

			CustomerEnquiry customerEnquiry = op.get();
			
			System.out.println(customerEnquiry.getCibilscore().getCibilId());

			CibilScore c = new CibilScore();
			c.setCibilId(customerEnquiry.getCibilscore().getCibilId());
			c.setCibilScore(b);
			c.setCibilStatus("Not Eligible");
			
			customerEnquiry.setCibilscore(c);

			er.save(customerEnquiry);
			return b;
		}
	}

	@Override
	public CustomerEnquiry saveStatus(CustomerEnquiry c) {

		CustomerEnquiry customerEnquiry = er.save(c);

		return customerEnquiry;
	}
}
