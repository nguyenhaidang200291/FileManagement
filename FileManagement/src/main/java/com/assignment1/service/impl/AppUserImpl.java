package com.assignment1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment1.model.AppUser;
import com.assignment1.repository.AppUserRepository;
import com.assignment1.service.AppUserService;

@Service
@Transactional
public class AppUserImpl implements AppUserService {
	
	@Autowired
	AppUserRepository appUserRepository;

	@Override
	public AppUser findByUserName(String username) {
		// TODO Auto-generated method stub
		return appUserRepository.findByUserName(username);
	}


}
