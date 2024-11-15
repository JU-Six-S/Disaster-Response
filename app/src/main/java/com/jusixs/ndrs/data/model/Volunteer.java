package com.jusixs.ndrs.data.model;

/**
 * Represents a volunteer with their details.
 */
public class Volunteer {

    private String name;
    private String contact;
    private String expertise;
    private String availability;

    /**
     * Constructor to initialize a Volunteer object.
     *
     * @param name        The name of the volunteer.
     * @param contact     The contact number of the volunteer.
     * @param expertise   The expertise of the volunteer.
     * @param availability The availability status of the volunteer.
     */
    public Volunteer(String name, String contact, String expertise, String availability) {
        this.name = name;
        this.contact = contact;
        this.expertise = expertise;
        this.availability = availability;
    }

    // Getters

    /**
     * Gets the name of the volunteer.
     *
     * @return The name of the volunteer.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the contact number of the volunteer.
     *
     * @return The contact number of the volunteer.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Gets the expertise of the volunteer.
     *
     * @return The expertise of the volunteer.
     */
    public String getExpertise() {
        return expertise;
    }

    /**
     * Gets the availability status of the volunteer.
     *
     * @return The availability status of the volunteer.
     */
    public String getAvailability() {
        return availability;
    }
}
