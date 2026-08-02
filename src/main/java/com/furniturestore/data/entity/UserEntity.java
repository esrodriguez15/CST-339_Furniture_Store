package com.furniturestore.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
<<<<<<< HEAD
 * Entity class that represents a user. 
 * Each field corresponds to column in the database.
=======
 * Represents a user account stored in the USERS database table.
>>>>>>> ebd241d669a4580cb724fa01bee8106c1f180e00
 */
@Table("USERS")
public class UserEntity
{
	
	@Id
	private Long id;

	@Column("FIRST_NAME")
	private String firstName;

	@Column("LAST_NAME")
	private String lastName;

	@Column("EMAIL")
	private String email;

	@Column("PHONE_NUMBER")
	private String phoneNumber;

	@Column("PASSWORD")
	private String password;

	/**
<<<<<<< HEAD
	 * Default constructor
=======
	 * Creates an empty user entity.
>>>>>>> ebd241d669a4580cb724fa01bee8106c1f180e00
	 */
	public UserEntity()
	{
	}

	/**
<<<<<<< HEAD
	 * Constructor used to create user entity
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param password
=======
	 * Creates a user entity with account information.
	 *
	 * @param id the user identifier
	 * @param firstName the user's first name
	 * @param lastName the user's last name
	 * @param email the user's email address
	 * @param phoneNumber the user's phone number
	 * @param password the user's encrypted password
>>>>>>> ebd241d669a4580cb724fa01bee8106c1f180e00
	 */
	public UserEntity(Long id, String firstName, String lastName,
			String email, String phoneNumber, String password)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	/**
	 * returns user ID
	 * @return
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * Sets user ID
	 * 
	 * @param id
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * Returns first name
	 * 
	 * @return
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * sets first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * returns last name
	 * 
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Sets last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * reutnrs user email
	 * 
	 * @return
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Sets user email
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Returns user phone number
	 * 
	 * @return
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Sets user phone number
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * return password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * set password
	 * 
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
}