package com.capgemini.adminsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.capgemini.adminsecurity.model.Admin;
import com.capgemini.adminsecurity.model.Coupon;
import com.capgemini.adminsecurity.model.Deal;
import com.capgemini.adminsecurity.service.AdminService;


@RestController
@RequestMapping("/adminSearch")
public class AdminController 
{
	@Autowired
	private AdminService service;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/saveAdmin")
	public Admin saveAdmin(@RequestBody Admin admin){
		return service.saveAdmin(admin);
		
	}
	
	
	//Get Method
	@GetMapping("/getAdmin/{adminUserName}")
	public Admin getAdmin(@PathVariable ("adminUserName") String adminUserName) {
		return service.findByUserName(adminUserName);
		
	}
	
	//Update Method
	@PutMapping("/updateProfile/{adminUserName}")
	public Admin updateAdmin(@PathVariable ("adminUserName") String adminUserName, @RequestBody Admin newAdmin)
	{
		Admin oldAdmin = service.findByUserName(adminUserName);
		oldAdmin.setPassword(newAdmin.getPassword());
		oldAdmin.setName(newAdmin.getName());
		service.saveAdmin(oldAdmin);
		return oldAdmin;
	}
	
	@PutMapping("/updateCoupon/{id}")
	public Object updateCoupon(@PathVariable("id") int id, @RequestBody Coupon coupon_new) {
		restTemplate.put("http://localhost:8081/coupon/updateById/{id}"+id, coupon_new);
		
		return coupon_new;
	}
	
	@PutMapping("/updateDeal/{id}")
	public Object updateDeal(@PathVariable("id") int id, @RequestBody Deal deal_new) {
		restTemplate.put("http://localhost:8082/deal/updateById/{id}"+id, deal_new);
		
		return deal_new;
	}
	
	@DeleteMapping("/deleteCoupon/{id}")
	public String deleteCoupon(@PathVariable("id") int id)
	{
		try {
		restTemplate.delete("http://localhost:8081/coupon/deleteById/{id}"+id);
		return "Deleted Successfully";
		}
		catch(Exception Ex)
		{
			System.out.println(Ex.getMessage());
			return "Not Deleted";
		}
	}
	
	@DeleteMapping("/deleteDeal/{id}")
	public String deleteDeal(@PathVariable("id") int id)
	{
		try {
		restTemplate.delete("http://localhost:8082/deal/deleteById/{id}"+id);
		return "Deleted Successfully";
		}
		catch(Exception Ex)
		{
			System.out.println(Ex.getMessage());
			return "Not Deleted";
		}
	}
	

}
