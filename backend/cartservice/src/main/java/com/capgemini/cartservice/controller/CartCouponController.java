package com.capgemini.cartservice.controller;

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

import com.capgemini.cartservice.model.CartCoupon;
import com.capgemini.cartservice.service.CartCouponService;



@RestController
@RequestMapping(value="/cart/cartcoupon")
public class CartCouponController 
{
	
	
	@Autowired
	CartCouponService cartCouponService;
	
	
	/*
       author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the controller for fetching all the details of the coupon in the cart.
	   url: http://localhost:8083/cartcoupon/list  
	*/
	@GetMapping(value="/list")
	public List<CartCoupon> getCartCouponDetails() 
	{
		
		
		List<CartCoupon> list = cartCouponService.findAll();
		return list;
		
	}
	
	
	/*
	 author : Annesha Debnath
	 creation date : 02.09.2022
	 modification date : 02.09.2022
	 description : This method acts as the controller for deleting all the details of the coupon in the cart 
	                using the id of that specific coupon.
	 url : http://localhost:8083/cartcoupon/deleteById/{id}  
	 */
	@DeleteMapping(value="/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") String id) 
	{
		
		
		
		cartCouponService.deleteById(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	/*
	    author : Annesha Debnath
	    creation date : 02.09.2022
	    modification date : 02.09.2022
        description : This method acts as the controller for adding new coupons in the cart.
	    url : http://localhost:8083/cartcoupon/add   
	*/
	@PostMapping(value="/add")
	public ResponseEntity<String> insertDetails(@RequestBody CartCoupon cartCoupon) 
	{
		
		
		
		System.out.println("Cart Details Saved");
		cartCoupon.setQuantity(1);
		cartCouponService.save(cartCoupon);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	
}
	
	/*
	    author : Annesha Debnath
	    creation date : 02.09.2022
	    modification date : 02.09.2022
	    description : This method acts as the controller for updating all the details of the specific
	                  coupon in the cart using the id of that coupons.
	     url : http://localhost:8083/cartcoupon/updateById/{id}
	 */
		@PutMapping("/updateById/{id}")
		public CartCoupon updateCoupon(@PathVariable("id") String id, @RequestBody CartCoupon cartCoupon)
		{
			
			
			CartCoupon c = cartCouponService.findById(id);
			
			c.setCouponId(cartCoupon.getCouponId());
			
			c.setCategory(cartCoupon.getCategory());
			
			
			c.setOffer(cartCoupon.getOffer());
			c.setCompanyName(cartCoupon.getCompanyName());
			
			c.setExpiryDate(cartCoupon.getExpiryDate());
			cartCouponService.save(c);
			return c;

			}
		
		@PutMapping("changeQuantity/{id}/{qty}")
		public String changeQuantityCoupon(@PathVariable("id") String id , @PathVariable("qty") int qty)
		{
			cartCouponService.changequantity(id,qty);
			return "qty updated";
		}

}
