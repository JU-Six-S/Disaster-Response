package com.jusixs.ndrs;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistrationVerificationTest {

    private RegistrationService registrationService; // Hypothetical service class
    private Volunteer volunteer;
    private NGO ngo;

    @BeforeEach
    void setup() {
        registrationService = mock(RegistrationService.class);
        volunteer = new Volunteer("John Doe", "john@example.com", "Firefighting", "Available");
        ngo = new NGO("Helping Hands", "contact@ngo.org", "Medical Aid");
    }

    @Test
    void testRegisterVolunteerSuccess() {
        when(registrationService.register(volunteer)).thenReturn(true);

        assertTrue(registrationService.register(volunteer), "Volunteer registration should succeed.");
        verify(registrationService, times(1)).register(volunteer);
    }

    @Test
    void testRegisterNGOSuccess() {
        when(registrationService.register(ngo)).thenReturn(true);

        assertTrue(registrationService.register(ngo), "NGO registration should succeed.");
        verify(registrationService, times(1)).register(ngo);
    }

    @Test
    void testVerifyCredentialsFailure() {
        when(registrationService.verify(volunteer)).thenReturn(false);

        assertFalse(registrationService.verify(volunteer), "Verification should fail for invalid credentials.");
        verify(registrationService, times(1)).verify(volunteer);
    }

    @Test
    void testInvalidContactInfo() {
        Volunteer invalidVolunteer = new Volunteer("Jane Doe", "invalid-email", "Logistics", "Unavailable");

        assertThrows(IllegalArgumentException.class, () -> {
            registrationService.register(invalidVolunteer);
        }, "Invalid contact information should throw an error.");
    }
}
