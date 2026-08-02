package com.furniturestore.data.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.furniturestore.data.entity.UserEntity;
import com.furniturestore.data.repository.UserRepository;

/**
 * Provides database operations for user accounts.
 */
@Service
public class UserDataService
{
	/**
	 * Repository used to access user records.
	 */
	private final UserRepository userRepository;

	public UserDataService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	/**
	 * Finds a user with the provided email and password.
	 *
	 * @param email the user's email address
	 * @param password the user's password
	 * @return the matching user, or an empty result if no user is found
	 */
	public Optional<UserEntity> findByEmailAndPassword(String email, String password)
	{
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	/**
	 * Finds a user by email address.
	 *
	 * @param email the user's email address
	 * @return the matching user, or an empty result if no user is found
	 */
	public Optional<UserEntity> findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

	/**
	 * Saves a new or updated user account.
	 *
	 * @param user the user account to save
	 * @return the saved user account
	 */
    public UserEntity save(UserEntity user)
    {
        return userRepository.save(user);
    }
}
