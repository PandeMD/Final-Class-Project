package com.ff.SpringBootSmallBusinessApp.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ff.SpringBootSmallBusinessApp.app.model.CustomerEnquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<CustomerEnquiry, Integer> {
	
	CustomerEnquiry findById(int enquiryId);


}
