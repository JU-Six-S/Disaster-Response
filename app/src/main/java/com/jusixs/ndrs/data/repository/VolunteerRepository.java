package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.Volunteer;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing volunteers.
 */
public class VolunteerRepository {

    // List to store registered volunteers
    private List<Volunteer> volunteerList;

    /**
     * Constructor to initialize the volunteer list.
     */
    public VolunteerRepository() {
        volunteerList = new ArrayList<>();
    }

    /**
     * Registers a volunteer by adding them to the list.
     *
     * @param volunteer The volunteer object to be registered.
     * @return {@code true} if the volunteer was successfully registered; {@code false} if registration failed.
     */
    public boolean registerVolunteer(Volunteer volunteer) {
        if (volunteer == null || volunteer.getName() == null || volunteer.getName().isEmpty() ||
                volunteer.getContact() == null || volunteer.getContact().isEmpty()) {
            return false; // Invalid volunteer data
        }

        volunteerList.add(volunteer); // Add the volunteer to the list
        return true; // Registration successful
    }

    /**
     * Retrieves a volunteer by their name.
     *
     * @param name The name of the volunteer to search for.
     * @return The volunteer object if found; {@code null} if no matching volunteer is found.
     */
    public Volunteer getVolunteer(String name) {
        if (name == null || name.isEmpty()) {
            return null; // Invalid name input
        }

        for (Volunteer volunteer : volunteerList) {
            if (volunteer.getName().equals(name)) {
                return volunteer; // Return the volunteer if found
            }
        }

        return null; // Volunteer not found
    }
}
