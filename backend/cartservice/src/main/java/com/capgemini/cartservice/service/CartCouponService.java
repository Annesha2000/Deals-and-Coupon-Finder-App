package com.capgemini.cartservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cartservice.model.CartCoupon;
import com.capgemini.cartservice.model.CartDeal;
import com.capgemini.cartservice.respository.CartCouponRespository;


@Service
public class CartCouponService 
{
	@Autowired
	private CartCouponRespository cartCouponRespository;
	
	/*
       author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the service for saving all the details of the coupon in the database.
	*/
	public CartCoupon save(CartCoupon cartCoupon) {
		
		return cartCouponRespository.save(cartCoupon);
		
	}
	
	/*
    author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the service for deleting all the details of the coupon in the 
	                database using the id of that specific coupon.
	*/
	public void deleteById(String id) 
	{
		cartCouponRespository.deleteById(id);
	}

	/*
    author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the service for fetching all the details of all coupons from the 
	                 database.
	*/
	public List<CartCoupon> findAll() {
		
		List<CartCoupon> list = cartCouponRespository.findAll();
		List<CartCoupon> list1=new ArrayList();
		for(int i =0 ; i<list.size();i++)
		{
			if(list.get(i).getOffer()!=null)
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
	   description : This method acts as the service for finding all the details of the coupon in the 
	                 database using the id of that specific coupon.
	*/
	public CartCoupon findById(String id) {
		
		return cartCouponRespository.findById(id).get();
	}

	public void changequantity(String id, int qty) {
		// TODO Auto-generated method stub
		CartCoupon c=cartCouponRespository.findById(id).get();
		c.setQuantity(qty);
		cartCouponRespository.save(c);
		
	}


}
