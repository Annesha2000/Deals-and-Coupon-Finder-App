package com.capgemini.cartservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cartservice.model.CartCoupon;
import com.capgemini.cartservice.model.CartDeal;
import com.capgemini.cartservice.respository.CartDealRespository;


@Service
public class CartDealService 
{
	@Autowired
	private CartDealRespository cartDealRespository;
	
	
	/*
    author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the service for saving all the details of the deal in the 
	                 database.
	*/
	public CartDeal save(CartDeal cartDeal) {
		
		return cartDealRespository.save(cartDeal);
		
	}

	/*
    author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the service for deleting all the details of the deal in the 
	                 database using the id of that specific coupon.
	*/
	public void deleteById(String id) 
	{
		cartDealRespository.deleteById(id);
	}

	
	/*
    author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the service for fetching all the details of all deal from the 
	                 database.
	*/
	public List<CartDeal> findAll() {
		
		List<CartDeal> list = cartDealRespository.findAll();
		List<CartDeal> list1=new ArrayList();
		for(int i =0 ; i<list.size();i++)
		{
			if(list.get(i).getName()!=null)
			{
				list1.add(list.get(i));
			}
		}
		return list1;
	}
	
	/*
    author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the service for finding all the details of the deal in the 
	                 database using the id of that specific coupon.
	*/
	public CartDeal findById(String id) {
		
		return cartDealRespository.findById(id).get();
	}
	
	public void changequantity(String id, int qty) {
		// TODO Auto-generated method stub
		CartDeal c=cartDealRespository.findById(id).get();
		c.setQuantity(qty);
		cartDealRespository.save(c);
		
	}

}
