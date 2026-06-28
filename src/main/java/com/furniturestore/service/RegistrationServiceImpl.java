/**
 * 
 */
package com.furniturestore.service;

import org.springframework.stereotype.Service;

import com.furniturestore.model.RegistrationModel;

/**
 * 
 */
@Service
public class RegistrationServiceImpl implements RegistrationServiceInterface {

	@Override
	public boolean validateRegistration(RegistrationModel model) {
		// hardwiredregistration logic
		return model.getPassword().equals(model.getConfirmPassword());
	}

}
