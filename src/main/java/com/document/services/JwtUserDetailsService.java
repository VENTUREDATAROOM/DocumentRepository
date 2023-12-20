package com.document.services;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.document.entity.GdmsApiUsers;
import com.document.repo.GdmsApiUserRepo;
import com.document.repo.UserEntranceRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserEntranceRepo entranceRepo;

	@Autowired
	GdmsApiUserRepo apiUserRepo;

	Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

	@Override
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		try {
			Optional<GdmsApiUsers> user = apiUserRepo.findByEmail(email);
			if (user == null || !user.isPresent()) {
				throw new UsernameNotFoundException("User not found with username: " + email);

			} else {
				return new User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
			}

		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found with username: " + email);
		}
 }
}