package com.capgemini.dealservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.dealservice.model.Deal;
import com.capgemini.dealservice.resopository.DealRespository;
import com.capgemini.dealservice.service.DealService;

import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
class DealserviceApplicationTests 
{
	
	@Autowired
	private DealService dealService;
	 
	@MockBean
	private DealRespository dealRepository;
	
	Deal deal = new Deal();
	
	List<Deal> dealList=new ArrayList<Deal>();
	
	/*
       author : Annesha Debnath
	   creation date : 03.09.2022
	   modification date : 03.09.2022
	   description : This method set all the attributes of the Deal object
	*/
	@BeforeEach
	public void setup() 
	{
		deal.setDealId("abcd");
		deal.setName("Speakers");
		deal.setPrice(100);
		deal.setCompanyName("Amazon");
		
		dealList.add(deal);
	}
	
	/*
       author : Annesha Debnath
	   creation date : 03.09.2022
	   modification date : 03.09.2022
	   description : This method does the junit test getDealDetails() method.
	*/
	@Test
	public void getCouponDetailsTest() {
		Mockito.when(dealService.findAll()).thenReturn(dealList);
		assertEquals(1, dealService.findAll().size());
	}
	
	/*
       author : Annesha Debnath
	   creation date : 03.09.2022
	   modification date : 03.09.2022
	   description : This method does the junit test insertDetails() method.
	*/
	@Test
	public void insertDetailsTest() {
		Mockito.when(dealRepository.save(deal)).thenReturn(deal);
		assertEquals(deal,dealService.save(deal));
	}
	
	/*
    author : Annesha Debnath
	   creation date : 03.09.2022
	   modification date : 03.09.2022
	   description : This method does the junit test findById() method.
	*/
	@Test
     public void findByIdTest() {
	Mockito.when(dealRepository.findById("abcd")).thenReturn(Optional.of(deal));
		assertEquals(deal, dealService.findById("abcd"));
	}
	
	/*
    author : Annesha Debnath
	   creation date : 03.09.2022
	   modification date : 03.09.2022
	   description : This method does the junit test deleteById() method.
	*/
	@Test
	public void deleteByIdTest() {
		Mockito.when(dealRepository.findById("abcd")).thenReturn(Optional.of(deal));
		dealService.deleteById("abcd");
		 Mockito.verify(dealRepository, Mockito.times(1)).deleteById("abcd");
	}

	

}
