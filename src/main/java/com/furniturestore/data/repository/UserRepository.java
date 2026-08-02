package com.furniturestore.data.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.furniturestore.data.entity.UserEntity;

/**
<<<<<<< HEAD
 * Extends Spring Data JDBC's CRUD Repository functions
=======
 * Repository used to perform database operations on user accounts.
>>>>>>> ebd241d669a4580cb724fa01bee8106c1f180e00
 */
public interface UserRepository extends CrudRepository<UserEntity, Long>
{
	/**
	 * Finds a user matching the provided email and password.
	 *
	 * @param email the user's email address
	 * @param password the user's password
	 * @return the matching user, or an empty result if no user is found
	 */
	Optional<UserEntity> findByEmailAndPassword(String email, String password);
	
	/**
	 * Finds a user by email address.
	 *
	 * @param email the user's email address
	 * @return the matching user, or an empty result if no user is found
	 */
	Optional<UserEntity> findByEmail(String email);
}
