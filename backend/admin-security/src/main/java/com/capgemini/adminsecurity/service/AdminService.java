package com.capgemini.adminsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.adminsecurity.model.Admin;
import com.capgemini.adminsecurity.repository.AdminRepository;



@Service
public class AdminService 
{
	@Autowired
	private AdminRepository adminRepository;

//	public Admin findByUserName(String userName) {
//		return adminrepo.findById(userName).get();
//	}
	public Admin findByUserName(String userName) {
		return adminRepository.findByUsername(userName);
	}

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

}
