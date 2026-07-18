package com.furniturestore.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.furniturestore.data.entity.UserEntity;
import com.furniturestore.data.service.UserDataService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
	private final UserDataService userDataService;

	public UserDetailsServiceImpl(UserDataService userDataService)
	{
		this.userDataService = userDataService;
	}

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