package com.furniturestore.data.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.furniturestore.data.entity.UserEntity;
import com.furniturestore.data.repository.UserRepository;

@Service
public class UserDataService
{
	private final UserRepository userRepository;

	public UserDataService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public Optional<UserEntity> findByEmailAndPassword(String email, String password)
	{
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	public Optional<UserEntity> findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public UserEntity save(UserEntity user)
    {
        return userRepository.save(user);
    }
}
