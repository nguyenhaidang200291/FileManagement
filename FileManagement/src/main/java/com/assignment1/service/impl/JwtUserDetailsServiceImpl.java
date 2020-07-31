package com.assignment1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assignment1.dto.AppUserDTO;
import com.assignment1.model.AppUser;
import com.assignment1.repository.AppUserRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = appUserRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getEncrytedPassword(),
				new ArrayList<>());
	}

	public AppUser save(AppUserDTO appUserDTO) {
		AppUser appUser = new AppUser();
		appUser.setUserName(appUserDTO.getUserName());
		appUser.setEncrytedPassword(bcryptEncoder.encode(appUserDTO.getPassword()));
		appUser.setEnabled(1);
		return appUserRepository.save(appUser);
	}
}