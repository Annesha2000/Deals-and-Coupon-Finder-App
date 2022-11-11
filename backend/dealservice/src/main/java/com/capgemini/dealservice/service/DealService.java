package com.capgemini.dealservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dealservice.model.Deal;
import com.capgemini.dealservice.resopository.DealRespository;



@Service
public class DealService 
{
	@Autowired
	private DealRespository dealRespository;
	
	/*
    author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the service for saving all the details of the deals in the database.
	*/
	public Deal save(Deal deal) {
		
		return dealRespository.save(deal);
		
	}

	/*
    author : Annesha Debnath
	   creation date : 01.09.2022
	   modification date : 01.09.2022
	   description : This method acts as the service for deleting all the details of the deal in the 
	                database using the id of that specific deal.
	*/
	public void deleteById(String id) 
	{
		dealRespository.deleteById(id);
	}

	/*
    author : Annesha Debnath
	   creation date : 01.09.2022
	   modification date : 01.09.2022
	   description : This method acts as the service for fetching all the details of all deal from the 
	                 database.
	*/
	public List<Deal> findAll() {
		
		List<Deal> list = new ArrayList<>();
		dealRespository.findAll().forEach(list::add);
		return list;
	}
	
	/*
    author : Annesha Debnath
	   creation date : 01.09.2022
	   modification date : 01.09.2022
	   description : This method acts as the service for finding all the details of the deal in the 
	                 database using the id of that specific deal.
	*/
	public Deal findById(String id) {
		
		return dealRespository.findById(id).get();
	}

}


