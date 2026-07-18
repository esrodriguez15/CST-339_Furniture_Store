package com.furniturestore.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.furniturestore.data.entity.UserEntity;
import com.furniturestore.data.service.UserDataService;
import com.furniturestore.model.RegistrationModel;

@Service
public class RegistrationServiceImpl implements RegistrationServiceInterface
{
	private final UserDataService userDataService;
	private final PasswordEncoder passwordEncoder;

	public RegistrationServiceImpl(
			UserDataService userDataService,
			PasswordEncoder passwordEncoder)
	{
		this.userDataService = userDataService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public boolean registerUser(RegistrationModel model)
	{
		// Check if email already exists.
		if (userDataService.findByEmail(model.getEmail()).isPresent())
		{
			return false;
		}

		// Convert model to entity.
		UserEntity user = new UserEntity();
		user.setFirstName(model.getFirstName());
		user.setLastName(model.getLastName());
		user.setEmail(model.getEmail());
		user.setPhoneNumber(model.getPhoneNumber());

		// Store the encrypted password in the database.
		user.setPassword(passwordEncoder.encode(model.getPassword()));

		// Save the user to the database.
		userDataService.save(user);

		return true;
	}
}