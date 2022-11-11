package com.capgemini.customersecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customersecurity.model.Customer;
import com.capgemini.customersecurity.service.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/createCustomer")
	public Customer saveCustomer(@RequestBody Customer customer){
		
		return customerService.create(customer);
	}
	

	
	@PutMapping("/updateCustomer/{mobile}")
	public Customer updatePass(@PathVariable("mobile") long mobile, @RequestBody Customer customer)
	{
		Customer c = customerService.getByMobile(mobile);
		
		c.setCustomerName(customer.getCustomerName());
		
		c.setCustomerMobile(customer.getCustomerMobile());
		
		c.setCustomerCreditNo(customer.getCustomerCreditNo());
		c.setCustomerBankName(customer.getCustomerBankName());
		c.setCustomerAddress(customer.getCustomerAddress());
		
		
		return customerService.create(c);
	}
	
	@GetMapping("/getCustomerByMobile/{mobile}")
	public Customer getPass(@PathVariable("mobile") long mobile)
	{
		return customerService.getByMobile(mobile);
	}
	
	@DeleteMapping("/deleteCustomer/{mobile}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("mobile") long mobile)
	{
	     String str = customerService.deleteCustomer(mobile);
	     return new ResponseEntity<String>(str, HttpStatus.OK);
	}

}
