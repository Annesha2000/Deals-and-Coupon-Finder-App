package com.capgemini.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.cartservice.model.CartDeal;
import com.capgemini.cartservice.service.CartDealService;




@RestController
@RequestMapping(value="/cart/cartdeal")
public class CartDealController 
{
	
	
	@Autowired
	CartDealService cartDealService;
	
	/*
       author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method acts as the controller for fetching all the details of the deal in the cart.
	   url: http://localhost:8083/cartdeal/list  
	*/
	@GetMapping(value="/list")
	public List<CartDeal> getDealDetails() 
	{
		
		
		List<CartDeal> list = cartDealService.findAll();
		return list;
		
	}
	
	/*
	 author : Annesha Debnath
	 creation date : 02.09.2022
	 modification date : 02.09.2022
	 description : This method acts as the controller for deleting all the details of the deal in the cart 
	                using the specific id of the coupon.
	 url : http://localhost:8083/cartdeal/deleteById/{id}  
	 */
	@DeleteMapping(value="/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") String id) 
	{
		
		
		cartDealService.deleteById(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	
	/*
    author : Annesha Debnath
    creation date : 02.09.2022
    modification date : 02.09.2022
    description : This method acts as the controller for adding new deals in the cart.
    url : http://localhost:8083/cartdeal/add   
*/
	@PostMapping(value="/add")
	public ResponseEntity<String> insertDetails(@RequestBody CartDeal cartDeal) 
	{
		
		System.out.println("Deal Details Saved");
		cartDeal.setQuantity(1);
		cartDealService.save(cartDeal);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	
}
	
	/*
    author : Annesha Debnath
    creation date : 02.09.2022
    modification date : 02.09.2022
    description : This method acts as the controller for updating all the details of the specific
                  deal in the cart using the id of that coupons.
     url : http://localhost:8083/cartdeal/updateById/{id}
 */
		@PutMapping("/updateById/{id}")
		public CartDeal updateCoupon(@PathVariable("id") String id, @RequestBody CartDeal cartdDeal)
		{
			
			
			CartDeal d = cartDealService.findById(id);
			
			d.setDealId(cartdDeal.getDealId());
			
			d.setName(cartdDeal.getName());
			d.setPrice(cartdDeal.getPrice());
			
			d.setCompanyName(cartdDeal.getCompanyName());
			
			d.setImgUrl(cartdDeal.getImgUrl());
			
			cartDealService.save(d);
			return d;

			}
		
		@PutMapping("changeQuantity/{id}/{qty}")
		public String changeQuantityDeal(@PathVariable("id") String id , @PathVariable("qty") int qty)
		{
			cartDealService.changequantity(id,qty);
			return "qty updated";
		}


}
