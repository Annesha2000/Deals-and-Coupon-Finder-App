package com.capgemini.couponservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.couponservice.model.Coupon;
import com.capgemini.couponservice.repository.CouponRespository;


@Service
public class CouponService 
{
	@Autowired
	private CouponRespository couponRespository;
	
	/*
    author : Annesha Debnath
	   creation date : 01.09.2022
	   modification date : 01.09.2022
	   description : This method acts as the service for saving all the details of the coupon in the database.
	*/
	public Coupon save(Coupon coupon) 
	{
		
		return couponRespository.save(coupon);
		
	}
	
	/*
    author : Annesha Debnath
	   creation date : 01.09.2022
	   modification date : 01.09.2022
	   description : This method acts as the service for deleting all the details of the coupon in the 
	                database using the id of that specific coupon.
	*/

	public void deleteById(String id) 
	{
		couponRespository.deleteById(id);
	}


	/*
    author : Annesha Debnath
	   creation date : 01.09.2022
	   modification date : 01.09.2022
	   description : This method acts as the service for fetching all the details of all coupons from the 
	                 database.
	*/
	public List<Coupon> findAll() {
		
		List<Coupon> list = new ArrayList<>();
		couponRespository.findAll().forEach(list::add);
		return list;
	}
	
	
	/*
    author : Annesha Debnath
	   creation date : 01.09.2022
	   modification date : 01.09.2022
	   description : This method acts as the service for finding all the details of the coupon in the 
	                 database using the id of that specific coupon.
	*/
	public Coupon findById(String id) {
		
		return couponRespository.findById(id).get();
	}

}
