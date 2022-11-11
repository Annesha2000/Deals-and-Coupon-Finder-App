package com.capgemini.adminsecurity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.adminsecurity.model.Admin;



public interface AdminRepository extends MongoRepository<Admin, String>
{
	Admin findByUsername(String username);
	  Boolean existsByUsername(String  username);
	  Boolean existsByEmail(String email);


}
