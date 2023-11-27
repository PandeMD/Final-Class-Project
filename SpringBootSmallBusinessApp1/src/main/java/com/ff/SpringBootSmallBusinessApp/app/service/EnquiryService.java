package com.ff.SpringBootSmallBusinessApp.app.service;

import com.ff.SpringBootSmallBusinessApp.app.model.CustomerEnquiry;

public interface EnquiryService {
    
	public CustomerEnquiry findEnquiryById(Integer enquiryId);

	public Iterable<CustomerEnquiry> displayEnquiry();

	public CustomerEnquiry saveEnquiry(CustomerEnquiry e);

	public Integer getCibil(Integer enquiryId);

	public CustomerEnquiry saveStatus(CustomerEnquiry c);

}
