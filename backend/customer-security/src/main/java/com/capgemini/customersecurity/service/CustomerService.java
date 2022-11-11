package com.capgemini.customersecurity.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customersecurity.model.Customer;
import com.capgemini.customersecurity.repository.CustomerRepository;



@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer create(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	public Customer getByMobile(long mobile)
	{
		return customerRepository.getbyMobile(mobile);
	}
	
	
	public String deleteCustomer(long mobile)
	{
		customerRepository.deleteByMobile(mobile);
		return "Deleted Successfully";
	}

}
