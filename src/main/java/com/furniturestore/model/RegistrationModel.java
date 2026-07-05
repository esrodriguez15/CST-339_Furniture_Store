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
	
	@NotBlank(message="Phone Number is a required field")
	@Size(min=10, max=15, message="Phone number must be between 10 and 15 characters")
	private String phoneNumber;
	
	@NotBlank(message="Password is a required field")
	@Size(min=6, max=32, message="Password must be between 6 and 32 characters")
	private String password;
	
	@NotBlank(message="Please confirm your password")
	@Size(min=6, max=32, message="Password must be between 6 and 32 characters")
	private String confirmPassword;
	
	/**
	 * Simple getter method that will return the First name.
	 * 
	 * @return String with email
	 */
	public String getFirstName() {
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
	
	/**getter for phoneNumber*/
	public String getPhoneNumber() {
	    return phoneNumber;
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
	 * setter for phone number
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
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
