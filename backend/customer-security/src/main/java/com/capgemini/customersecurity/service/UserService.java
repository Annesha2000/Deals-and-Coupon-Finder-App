package com.capgemini.customersecurity.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customersecurity.model.User;
import com.capgemini.customersecurity.repository.UserRepository;


@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
	public User getByEmailId(String email)
	{
		return userRepository.getByEmail(email);
	}
	
	public String deleteByEmailId(String email)
	{
		userRepository.deleteByEmail(email);
		 return "deleted Successfully";
		
	}

}
