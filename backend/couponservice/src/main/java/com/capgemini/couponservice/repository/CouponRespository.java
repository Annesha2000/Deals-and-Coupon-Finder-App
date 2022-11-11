package com.capgemini.couponservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.couponservice.model.Coupon;


/*
author : Annesha Debnath
creation date : 02.09.2022
modification date : 02.09.2022
description : This creates an interface CouponRespository which extends the MongoRepository 
              which an interface provided by Spring Data in the package org.springframework.data.mongodb.repository.
              MongoRepository provides all the necessary methods which help to create a
              CRUD application and it also supports the custom derived query methods.
*/
@Repository
public interface CouponRespository extends MongoRepository<Coupon, String> 
{
     
}
