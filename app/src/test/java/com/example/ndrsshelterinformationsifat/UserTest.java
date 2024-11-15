package com.example.ndrsshelterinformationsifat.data.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for User.
 */
public class UserTest {

    @Test
    public void testUserConstructor() {
        // Create a User object with test values
        String email = "test@example.com";
        String password = "password123";
        User user = new User(email, password);

        // Assert that the email and password are set correctly
        assertEquals("Email should be set correctly", email, user.getEmail());
        assertEquals("Password should be set correctly", password, user.getPassword());
    }

    @Test
    public void testGetEmail() {
        String email = "test@example.com";
        String password = "password123";
        User user = new User(email, password);

        // Assert that the getEmail method returns the correct email
        assertEquals("getEmail should return the correct email", email, user.getEmail());
    }

    @Test
    public void testGetPassword() {
        String email = "test@example.com";
        String password = "password123";
        User user = new User(email, password);

        // Assert that the getPassword method returns the correct password
        assertEquals("getPassword should return the correct password", password, user.getPassword());
    }
}
