package com.makersharks.ManuSearch.service;

import com.makersharks.ManuSearch.exception.ManuSearchException;
import com.makersharks.ManuSearch.entity.User;
import com.makersharks.ManuSearch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the AuthService interface.
 * This class handles authentication-related operations and user registration.
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository; // Repository for user data access

    /**
     * Retrieves the authentication details of the currently authenticated user.
     *
     * @param auth the authentication object containing user details
     * @return the authentication details of the currently authenticated user
     * @throws ManuSearchException if authentication details are not found
     */
    @Override
    public Authentication getAuthenticationDetails(Authentication auth) {
        return Optional.ofNullable(auth)
                .orElseThrow(() -> new ManuSearchException("Authentication details not found"));
    }

    /**
     * Registers a new user and saves their details to the database.
     *
     * @param user the User object containing the details of the user to register
     * @return a success message indicating the registration status
     * @throws ManuSearchException if user registration fails
     */
    @Override
    public String registerUser(User user) {
        return Optional.ofNullable(user)
                .map(userRepository::save) // Save the user to the database
                .map(savedUser -> "Successfully registered: " + savedUser.getEmail()) // Return success message with user's email
                .orElseThrow(() -> new ManuSearchException("User registration failed")); // Throw exception if registration fails
    }

}
