package com.ff.SpringBootSmallBusinessApp.app.service;

import java.util.List;

import com.ff.SpringBootSmallBusinessApp.app.model.Customer;

public interface CustomerService {

	Customer save(Customer c);

	List<Customer> getAll();

	Customer findbyId(Integer customerId);

	void deletecustomer(Integer customerId);

}
