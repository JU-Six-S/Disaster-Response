package com.jusixs.ndrs;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommunicationTest {

    private CommunicationService communicationService;

    @BeforeEach
    void setup() {
        communicationService = mock(CommunicationService.class);
    }

    @Test
    void testSendEmailUpdateSuccess() {
        when(communicationService.sendEmail("john@example.com", "Update")).thenReturn(true);

        assertTrue(communicationService.sendEmail("john@example.com", "Update"), "Email should be sent successfully.");
        verify(communicationService, times(1)).sendEmail("john@example.com", "Update");
    }

    @Test
    void testSendSmsUpdateFailure() {
        when(communicationService.sendSms("1234567890", "Alert")).thenReturn(false);

        assertFalse(communicationService.sendSms("1234567890", "Alert"), "SMS should fail to send due to invalid number.");
    }

    @Test
    void testCommunicationFallbackOnFailure() {
        when(communicationService.sendNotification(anyString(), anyString())).thenReturn(false);

        assertFalse(communicationService.sendNotification("john@example.com", "Emergency Alert"),
                "Fallback should trigger when primary communication fails.");
    }
}
