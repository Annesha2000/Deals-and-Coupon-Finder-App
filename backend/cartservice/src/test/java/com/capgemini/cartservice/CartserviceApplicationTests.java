package com.capgemini.cartservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.cartservice.model.CartCoupon;
import com.capgemini.cartservice.model.CartDeal;
import com.capgemini.cartservice.respository.CartCouponRespository;
import com.capgemini.cartservice.respository.CartDealRespository;
import com.capgemini.cartservice.service.CartCouponService;
import com.capgemini.cartservice.service.CartDealService;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CartserviceApplicationTests
{
	@Autowired
	private CartCouponService cartCouponService;

	@Autowired
	private CartDealService cartDealService;
	 
	@MockBean
	private CartCouponRespository cartCouponRepository;
	
	@MockBean
	private CartDealRespository cartDealRepository;
	
   CartCoupon cartCoupon = new CartCoupon();
   CartDeal cartDeal = new CartDeal();
	
   List<CartCoupon> cartCouponList=new ArrayList<CartCoupon>();
   List<CartDeal> cartDealList=new ArrayList<CartDeal>();
	
   /*
   author : Annesha Debnath
   creation date : 03.09.2022
   modification date : 03.09.2022
   description : This method set all the attributes of the Coupon and Deal object
*/
   @BeforeEach
	public void setup() 
	{
		cartCoupon.setCouponId("abcd");
		cartCoupon.setCategory("clothing");
		
		cartCoupon.setPrice(100);
		cartCoupon.setCompanyName("Amazon");
		cartCoupon.setOffer("50% off");
		cartCoupon.setExpiryDate("22 oct 2022");
		
		cartCouponList.add(cartCoupon);
		
		cartDeal.setDealId("abcd");
		cartDeal.setName("Speakers");
		cartDeal.setPrice(100);
		cartDeal.setCompanyName("JBL");
		
		cartDealList.add(cartDeal);
	}
	
	/*
   author : Annesha Debnath
   creation date : 03.09.2022
   modification date : 03.09.2022
   description : This method does the junit test getCartCouponDetails() method .
   */
    @Test
    public void getDetailsTest1() {
	Mockito.when(cartCouponService.findAll()).thenReturn(cartCouponList);
	assertEquals(1, cartCouponService.findAll().size());
     }

   /*
   author : Annesha Debnath
   creation date : 03.09.2022
   modification date : 03.09.2022
   description : This method does the junit test insertDetails() method.
  */
   @Test
    public void insertDetailsTest1() {
	Mockito.when(cartCouponRepository.save(cartCoupon)).thenReturn(cartCoupon);
	assertEquals(cartCoupon,cartCouponService.save(cartCoupon));
    }

    /*
    author : Annesha Debnath
   creation date : 03.09.2022
   modification date : 03.09.2022
   description : This method does the junit test findById() method.
    */
    @Test
     public void findByIdTest1() {
     Mockito.when(cartCouponRepository.findById("abcd")).thenReturn(Optional.of(cartCoupon));
	assertEquals(cartCoupon, cartCouponService.findById("abcd"));
    }

    /*
    author : Annesha Debnath
   creation date : 03.09.2022
   modification date : 03.09.2022
    description : This method does the junit test deleteById() method.
   */
     @Test
    public void deleteByIdTest1() {
	Mockito.when(cartCouponRepository.findById("abcd")).thenReturn(Optional.of(cartCoupon));
	cartCouponService.deleteById("abcd");
	 Mockito.verify(cartCouponRepository, Mockito.times(1)).deleteById("abcd");
    }
     
     
     /*
     author : Annesha Debnath
     creation date : 03.09.2022
     modification date : 03.09.2022
     description : This method does the junit test getCartDealDetails() method .
     */
      @Test
      public void getDetailsTest2() {
  	Mockito.when(cartDealService.findAll()).thenReturn(cartDealList);
  	assertEquals(1, cartDealService.findAll().size());
       }

     /*
     author : Annesha Debnath
     creation date : 03.09.2022
     modification date : 03.09.2022
     description : This method does the junit test insertDetails() method.
    */
     @Test
      public void insertDetailsTest2() {
  	Mockito.when(cartDealRepository.save(cartDeal)).thenReturn(cartDeal);
  	assertEquals(cartDeal,cartDealService.save(cartDeal));
      }

      /*
      author : Annesha Debnath
     creation date : 03.09.2022
     modification date : 03.09.2022
     description : This method does the junit test findById() method.
      */
      @Test
       public void findByIdTest2() {
       Mockito.when(cartDealRepository.findById("abcd")).thenReturn(Optional.of(cartDeal));
  	assertEquals(cartDeal, cartDealService.findById("abcd"));
      }

      /*
      author : Annesha Debnath
     creation date : 03.09.2022
     modification date : 03.09.2022
      description : This method does the junit test deleteById() method.
     */
       @Test
      public void deleteByIdTest2() {
  	Mockito.when(cartDealRepository.findById("abcd")).thenReturn(Optional.of(cartDeal));
  	cartDealService.deleteById("abcd");
  	 Mockito.verify(cartDealRepository, Mockito.times(1)).deleteById("abcd");
      }



}
