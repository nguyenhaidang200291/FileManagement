package com.assignment1.service;

import com.assignment1.model.AppUser;

public interface AppUserService {	
	AppUser findByUserName(String username);
}
