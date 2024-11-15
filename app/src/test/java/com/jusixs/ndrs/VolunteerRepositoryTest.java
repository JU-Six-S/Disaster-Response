package com.jusixs.ndrs;

import com.jusixs.ndrs.data.model.Volunteer;
import com.jusixs.ndrs.data.repository.VolunteerRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the VolunteerRepository class.
 */
public class VolunteerRepositoryTest {

    private VolunteerRepository volunteerRepository;

    /**
     * Sets up the VolunteerRepository instance before each test case.
     */
    @Before
    public void setup() {
        volunteerRepository = new VolunteerRepository();
    }

    /**
     * Tests the successful registration of a valid volunteer.
     */
    @Test
    public void testRegisterVolunteerValid() {
        // Arrange: Create a valid Volunteer instance
        Volunteer volunteer = new Volunteer("John Doe", "1234567890", "Medical", "Available");

        // Act: Register the volunteer
        boolean result = volunteerRepository.registerVolunteer(volunteer);

        // Assert: Verify the registration was successful
        assertTrue(result);
    }

    /**
     * Tests the failure of registering an invalid volunteer with empty fields.
     */
    @Test
    public void testRegisterVolunteerInvalid() {
        // Arrange: Create an invalid Volunteer instance with empty name and contact
        Volunteer volunteer = new Volunteer("", "", "Medical", "Available");

        // Act: Attempt to register the invalid volunteer
        boolean result = volunteerRepository.registerVolunteer(volunteer);

        // Assert: Verify the registration failed
        assertFalse(result);
    }

    /**
     * Tests fetching a valid volunteer by name after registration.
     */
    @Test
    public void testGetVolunteerValid() {
        // Arrange: Create and register a valid Volunteer instance
        Volunteer volunteer = new Volunteer("John Doe", "1234567890", "Medical", "Available");
        volunteerRepository.registerVolunteer(volunteer);

        // Act: Fetch the registered volunteer by name
        Volunteer fetchedVolunteer = volunteerRepository.getVolunteer("John Doe");

        // Assert: Verify the fetched volunteer is not null and matches the registered volunteer's name
        assertNotNull(fetchedVolunteer);
        assertEquals("John Doe", fetchedVolunteer.getName());
    }

    /**
     * Tests fetching a volunteer by a non-existent name.
     */
    @Test
    public void testGetVolunteerInvalid() {
        // Act: Attempt to fetch a volunteer that does not exist
        Volunteer fetchedVolunteer = volunteerRepository.getVolunteer("NonExistingVolunteer");

        // Assert: Verify the fetched volunteer is null
        assertNull(fetchedVolunteer);
    }
}
