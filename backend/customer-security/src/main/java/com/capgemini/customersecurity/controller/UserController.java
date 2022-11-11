package com.capgemini.customersecurity.controller;



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


import com.capgemini.customersecurity.model.User;
import com.capgemini.customersecurity.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/findUserByMail/{email}")
	public User findbymail(@PathVariable("email") String email)
	{
		return userService.getByEmailId(email);
	}
	
	@PostMapping("/createUser")
	public User saveuser(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	@PutMapping("/updateUserByMail/{email}")
	public User updateUser(@PathVariable("email") String email, @RequestBody User user1)
	{
		User user0 = userService.getByEmailId(email);
		user0.setEmail(user1.getEmail());
		user0.setPassword(user1.getPassword());
		user0.setPhone(user1.getPhone());
		userService.createUser(user0);
		return user0;
	}
	
	@DeleteMapping("/deleteUser/{email}")
	public ResponseEntity<String> deletePass(@PathVariable("email") String email)
	{
	     String str = userService.deleteByEmailId(email);
	     return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	

}
