package com.capgemini.couponservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.capgemini.couponservice.model.Coupon;
import com.capgemini.couponservice.repository.CouponRespository;
import com.capgemini.couponservice.service.CouponService;

@SpringBootTest
class CouponserviceApplicationTests {

	@Autowired
	private CouponService couponService;
	 
	@MockBean
	private CouponRespository couponRepository;
	
	Coupon coupon = new Coupon();
	
	List<Coupon> couponList=new ArrayList<Coupon>();
	
	/*
       author : Annesha Debnath
	   creation date : 03.09.2022
	   modification date : 03.09.2022
	   description : This method set all the attributes of the Coupon object
	*/
	@BeforeEach
	public void setup() 
	{
		coupon.setCouponId("abcd");
		coupon.setCategory("clothing");
		
		coupon.setPrice(100);
		coupon.setCompanyName("Amazon");
		coupon.setOffer("50% off");
		coupon.setExpiryDate("22 oct 2022");
		
		couponList.add(coupon);
	}
	
	/*
       author : Annesha Debnath
	   creation date : 03.09.2022
	   modification date : 03.09.2022
	   description : This method does the junit test getCouponDetails() method.
	*/
	@Test
	public void getCouponDetailsTest() {
		Mockito.when(couponService.findAll()).thenReturn(couponList);
		assertEquals(1, couponService.findAll().size());
	}
	
	/*
       author : Annesha Debnath
	   creation date : 03.09.2022
	   modification date : 03.09.2022
	   description : This method does the junit test insertDetails() method.
	*/
	@Test
	public void insertDetailsTest() {
		Mockito.when(couponRepository.save(coupon)).thenReturn(coupon);
		assertEquals(coupon,couponService.save(coupon));
	}
	
	/*
    author : Annesha Debnath
	   creation date : 03.09.2022
	   modification date : 03.09.2022
	   description : This method does the junit test findById() method.
	*/
	@Test
     public void findByIdTest() {
	Mockito.when(couponRepository.findById("abcd")).thenReturn(Optional.of(coupon));
		assertEquals(coupon, couponService.findById("abcd"));
	}
	
	/*
    author : Annesha Debnath
	   creation date : 03.09.2022
	   modification date : 03.09.2022
	   description : This method does the junit test deleteById() method.
	*/
	@Test
	public void deleteByIdTest() {
		Mockito.when(couponRepository.findById("abcd")).thenReturn(Optional.of(coupon));
		couponService.deleteById("abcd");
		 Mockito.verify(couponRepository, Mockito.times(1)).deleteById("abcd");
	}
	
	
	
	
}
