package com.capgemini.customersecurity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.customersecurity.model.User;



@Repository
public interface UserRepository extends MongoRepository<User, String>
{
	@Query("{email: ?0}")
	User getByEmail(String email);
	
	
	@Query(value="{'email' : ?0}", delete = true)
	public void deleteByEmail(String email);
	
	
     User findByUsername(String username);
	  Boolean existsByUsername(String username);
	  Boolean existsByEmail(String email);

}
