package com.capgemini.cartservice.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cartservice.model.CartDeal;

/*
author : Annesha Debnath
creation date : 02.09.2022
modification date : 02.09.2022
description : This creates an interface CartDealRespository which extends the MongoRepository 
              which an interface provided by Spring Data in the package org.springframework.data.mongodb.repository.
              MongoRepository provides all the necessary methods which help to create a
              CRUD application and it also supports the custom derived query methods.
*/
@Repository
public interface CartDealRespository extends MongoRepository<CartDeal, String> 
{
     
}
