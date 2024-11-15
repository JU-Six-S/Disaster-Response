package com.example.ndrsshelterinformationsifat.data.model;

/**
 * Represents a user with an email and password.
 */
public class User {
    private final String email;
    private final String password;

    /**
     * Constructs a User with the specified email and password.
     * @param email the user's email address
     * @param password the user's password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Returns the email address of the user.
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the password of the user.
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
