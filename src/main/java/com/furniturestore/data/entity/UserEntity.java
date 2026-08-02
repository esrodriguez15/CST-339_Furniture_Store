package com.furniturestore.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Represents a user account stored in the USERS database table.
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
	 * Creates an empty user entity.
	 */
	public UserEntity()
	{
	}

	/**
	 * Creates a user entity with account information.
	 *
	 * @param id the user identifier
	 * @param firstName the user's first name
	 * @param lastName the user's last name
	 * @param email the user's email address
	 * @param phoneNumber the user's phone number
	 * @param password the user's encrypted password
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

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}