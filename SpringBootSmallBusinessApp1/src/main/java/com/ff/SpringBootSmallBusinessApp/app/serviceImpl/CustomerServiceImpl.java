package com.ff.SpringBootSmallBusinessApp.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.SpringBootSmallBusinessApp.app.model.Customer;
import com.ff.SpringBootSmallBusinessApp.app.repositary.CustomerRepository;
import com.ff.SpringBootSmallBusinessApp.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

   @Autowired	
   CustomerRepository repository;
    
	@Override
	public Customer save(Customer c) {

		return repository.save(c);
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Customer findbyId(Integer customerId) {
		// TODO Auto-generated method stub
		return repository.findAllByCustomerId(customerId);
	}

	@Override
	public void deletecustomer(Integer customerId) {
		// TODO Auto-generated method stub
	
		
		repository.deleteById(customerId);
	}

	

}
