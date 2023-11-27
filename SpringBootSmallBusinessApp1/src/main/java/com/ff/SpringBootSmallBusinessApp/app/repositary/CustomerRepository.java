package com.ff.SpringBootSmallBusinessApp.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ff.SpringBootSmallBusinessApp.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

	public Customer findAllByCustomerId(Integer customerId);
	
}
