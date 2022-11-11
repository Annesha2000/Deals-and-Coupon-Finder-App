package com.capgemini.dealservice.controller;

import java.util.List;

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


import com.capgemini.dealservice.model.Deal;
import com.capgemini.dealservice.service.DealService;


@RestController
@RequestMapping(value="/deal")
public class DealController 
{
	
	
	
	@Autowired
	DealService dealService;
	
	/*
    author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the controller for fetching details of all deals  .
	   url: http://localhost:8082/deal/list  
	*/
	@GetMapping(value="/list")
	public List<Deal> getDealDetails() 
	{
		
		
		List<Deal> list = dealService.findAll();
		return list;
		
	}
	
	/*
	 author : Annesha Debnath
	 creation date : 02.09.2022
	 modification date : 02.09.2022
	 description : This method acts as the controller for deleting all the details of the deal 
	                using the id of that specific deal.
	 url : http://localhost:8082/deal/deleteById/{id}  
	 */
	@DeleteMapping(value="/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") String id) 
	{
		
		dealService.deleteById(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	/*
    author : Annesha Debnath
    creation date : 02.09.2022
    modification date : 02.09.2022
    description : This method acts as the controller for adding new deals .
    url : http://localhost:8082/deal/add   
*/
	@PostMapping(value="/add")
	public ResponseEntity<String> insertDetails(@RequestBody Deal deal) 
	{
		
		
		System.out.println("Deal Details Saved");
		dealService.save(deal);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	
}
	
	/*
    author : Annesha Debnath
    creation date : 02.09.2022
    modification date : 02.09.2022
    description : This method acts as the controller for updating all the details of the specific
                  deal using the id of that deal.
     url : http://localhost:8082/deal/updateById/{id}
 */
		@PutMapping("/updateById/{id}")
		public Deal updateCoupon(@PathVariable("id") String id, @RequestBody Deal deal)
		{
			
			Deal d = dealService.findById(id);
			
			d.setDealId(deal.getDealId());
			
			d.setName(deal.getName());
			d.setPrice(deal.getPrice());
			
			d.setCompanyName(deal.getCompanyName());
			d.setImgUrl(deal.getImgUrl());
			
			dealService.save(d);
			return d;

			}

}
