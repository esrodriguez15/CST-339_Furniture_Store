package com.furniturestore.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistrationModel
{
	@NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;
    
	@NotBlank(message="Email is a required field")
	@Email(message = "Please enter a valid email address")
	private String email;
	
	@NotBlank(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;
	
	@NotBlank(message="Please confirm your password")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String confirmPassword;
	
	/**
	 * Simple getter method that will return the First name.
	 * 
	 * @return String with email
	 */
	public String getfirstName() {
		return firstName;
	}
	
	/**
	 * Simple Setter that will set the First Name to the String in the parameters
	 * @param name
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Simple getter method that will return the Last name.
	 * 
	 * @return String with email
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Simple Setter that will set the First Name to the String in the parameters
	 * @param name
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * Simple getter method that will return the email.
	 * 
	 * @return String with email
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * Simple getter method that will return the password
	 * 
	 * @return String with password
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * Simple Setter that will set the email to the String in the parameters
	 * @param name
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * Simple Setter that will set the password to the String in the parameters.
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
