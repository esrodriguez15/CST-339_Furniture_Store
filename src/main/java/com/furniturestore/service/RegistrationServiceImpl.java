package com.furniturestore.service;

import org.springframework.stereotype.Service;

import com.furniturestore.data.entity.UserEntity;
import com.furniturestore.data.service.UserDataService;
import com.furniturestore.model.RegistrationModel;

@Service
public class RegistrationServiceImpl implements RegistrationServiceInterface
{
    private final UserDataService userDataService;

    public RegistrationServiceImpl(UserDataService userDataService)
    {
        this.userDataService = userDataService;
    }

    @Override
    public boolean registerUser(RegistrationModel model)
    {
        // Check if email already exists
        if (userDataService.findByEmail(model.getEmail()).isPresent())
        {
            return false;
        }

        // Convert model -> entity
        UserEntity user = new UserEntity();
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setPhoneNumber(model.getPhoneNumber());
        user.setPassword(model.getPassword());

        // Save to DB
        userDataService.save(user);

        return true;
    }
}
