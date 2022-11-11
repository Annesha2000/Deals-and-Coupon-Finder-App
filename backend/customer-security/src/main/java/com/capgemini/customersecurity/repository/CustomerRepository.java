package com.capgemini.customersecurity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.customersecurity.model.Customer;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer>
{
	@Query("{pass_mobile: ?0}")
	Customer getbyMobile(long mobile);
	
	
	@Query(value="{'pass_mobile' : ?0}", delete = true)
	public void deleteByMobile(long pass_mobile);
	
}