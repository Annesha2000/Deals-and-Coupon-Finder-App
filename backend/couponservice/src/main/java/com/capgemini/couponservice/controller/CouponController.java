package com.capgemini.couponservice.controller;

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

import com.capgemini.couponservice.model.Coupon;
import com.capgemini.couponservice.service.CouponService;



@RestController
@RequestMapping(value="/coupon")
public class CouponController 
{
	
	@Autowired
	CouponService couponService;
	

	/*
    author : Annesha Debnath
	   creation date : 01.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the controller for fetching details of all coupons .
	   url: http://localhost:8081/coupon/list  
	*/
	@GetMapping(value="/list")
	public List<Coupon> getCouponDetails() 
	{
		
		
		List<Coupon> list = couponService.findAll();
		return list;
		
	}
	
	
	/*
	 author : Annesha Debnath
	 creation date : 01.09.2022
	 modification date : 02.09.2022
	 description : This method acts as the controller for deleting all the details of the coupon 
	                using the id of that specific coupon.
	 url : http://localhost:8081/coupon/deleteById/{id}  
	 */
	@DeleteMapping(value="/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") String id) 
	{
		
		couponService.deleteById(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	/*
    author : Annesha Debnath
    creation date : 02.09.2022
    modification date : 02.09.2022
    description : This method acts as the controller for adding new coupons .
    url : http://localhost:8081/coupon/add   
*/
	@PostMapping(value="/add")
	public ResponseEntity<String> insertDetails(@RequestBody Coupon coupon) 
	{
		
		
		System.out.println("Coupon Details Saved");
		couponService.save(coupon);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	
}
	/*
    author : Annesha Debnath
    creation date : 02.09.2022
    modification date : 02.09.2022
    description : This method acts as the controller for updating all the details of the specific
                  coupon using the id of that coupon.
     url : http://localhost:8081/coupon/updateById/{id}
 */
		@PutMapping("/updateById/{id}")
		public Coupon updateCoupon(@PathVariable("id") String id, @RequestBody Coupon coupon)
		{
			
			
	        
			Coupon c = couponService.findById(id);
			
			c.setCouponId(coupon.getCouponId());
			
			c.setCategory(coupon.getCategory());
			
			
			c.setOffer(coupon.getOffer());
			c.setCompanyName(coupon.getCompanyName());
			
			c.setExpiryDate(coupon.getExpiryDate());
			couponService.save(c);
			return c;

			}

}
