package com.furniturestore.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.furniturestore.data.entity.UserEntity;
import com.furniturestore.data.service.UserDataService;


/**
 * Implementation of Spring Security's UserDetailsService
 * 
 * Loads user details from database with SPring DataJDBC
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
	private final UserDataService userDataService;

	/**
	 * Provides user repository
	 * @param userDataService
	 */
	public UserDetailsServiceImpl(UserDataService userDataService)
	{
		this.userDataService = userDataService;
	}

	/**
	 * Loads user by email for authentication
	 */
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException
	{
		UserEntity user = userDataService.findByEmail(email)
				.orElseThrow(() ->
						new UsernameNotFoundException(
								"User not found with email: " + email));

		return User.withUsername(user.getEmail())
				.password(user.getPassword())
				.roles("USER")
				.build();
	}
}