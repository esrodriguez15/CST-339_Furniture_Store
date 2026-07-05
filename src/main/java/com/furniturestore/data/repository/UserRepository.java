package com.furniturestore.data.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.furniturestore.data.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>
{
	Optional<UserEntity> findByEmailAndPassword(String email, String password);
	
	/*
	 * This will be used to check if the email is already registered.
	 */
	Optional<UserEntity> findByEmail(String email);
}
