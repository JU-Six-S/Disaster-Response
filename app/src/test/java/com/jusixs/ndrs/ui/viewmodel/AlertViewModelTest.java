package com.jusixs.ndrs.ui.viewmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.jusixs.ndrs.data.model.Alert;
import com.jusixs.ndrs.data.repository.AlertRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit tests for the AlertViewModel using JUnit and Mockito.
 * Ensures that AlertViewModel correctly updates its LiveData based on repository response.
 */
@RunWith(MockitoJUnitRunner.class)
public class AlertViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Mock
    private AlertRepository repository;

    private AlertViewModel viewModel;

    @Mock
    private Observer<String> observer;

    /**
     * Sets up the test environment by initializing mocks and the ViewModel,
     * and attaching an observer to the alertStatus LiveData.
     */
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        viewModel = new AlertViewModel(repository);
        viewModel.getAlertStatus().observeForever(observer);
    }


    /**
     * Tests the scenario where the alert is successfully sent.
     * Verifies that the alertStatus LiveData is updated to "sent".
     */
    @Test
    public void getAlertStatus() {
        Alert alert = new Alert();
        alert.setStatus("sent");
        when(repository.sendAlert(alert)).thenReturn(alert);

        viewModel.sendAlert("general", "Weather Update", "citizens", "normal", "Dhaka");

        // Verify that the alert status is set to "sent"
        assertEquals("sent", viewModel.getAlertStatus().getValue());
    }

    /**
     * Tests the scenario where sending the alert fails.
     * Verifies that the alertStatus LiveData is updated to "failed".
     */
    @Test
    public void sendAlert() {
        Alert alert = new Alert();
        alert.setStatus("failed");
        when(repository.sendAlert(alert)).thenReturn(alert);

        viewModel.sendAlert("emergency", "Evacuation Notice", "both", "high", "Chattogram");

        // Verify that the alert status is set to "failed"
        assertEquals("failed", viewModel.getAlertStatus().getValue());
    }

    /**
     * Tests that the alert status is null initially before any alert is sent.
     */
    @Test
    public void defaultAlertStatus() {
        assertEquals(null, viewModel.getAlertStatus().getValue(), "Alert status should be null initially");
    }

    /**
     * Tests sending a high priority emergency alert.
     * Verifies that the alert status is updated to "sent".
     */
    @Test
    public void sendHighPriorityEmergencyAlert() {
        Alert alert = new Alert();
        alert.setStatus("sent");
        when(repository.sendAlert(alert)).thenReturn(alert);

        viewModel.sendAlert("emergency", "Critical flood warning", "firstResponders", "high", "Dhaka");

        // Verify that the alert status is set to "sent"
        assertEquals("sent", viewModel.getAlertStatus().getValue());
    }

    /**
     * Tests sending an alert with an invalid audience.
     * Verifies that the alert status is updated to "failed".
     */
    @Test
    public void sendAlertWithInvalidAudience() {
        Alert alert = new Alert();
        alert.setStatus("failed");
        when(repository.sendAlert(alert)).thenReturn(alert);

        viewModel.sendAlert("general", "Test message", "invalidAudience", "normal", "Dhaka");

        // Verify that the alert status is set to "failed"
        assertEquals("failed", viewModel.getAlertStatus().getValue());
    }

    /**
     * Tests sending an alert with a missing location.
     * Verifies that the alert status is updated to "failed".
     */
    @Test
    public void sendAlertWithMissingLocation() {
        Alert alert = new Alert();
        alert.setStatus("failed");
        when(repository.sendAlert(alert)).thenReturn(alert);

        viewModel.sendAlert("general", "Location missing test", "citizens", "normal", null);

        // Verify that the alert status is set to "failed"
        assertEquals("failed", viewModel.getAlertStatus().getValue());
    }

    /**
     * Tests sending an alert with a network error during the send process.
     * Verifies that the alert status is updated to "failed".
     */
    @Test
    public void sendAlertWithNetworkError() {
        Alert alert = new Alert();
        alert.setStatus("failed");
        when(repository.sendAlert(alert)).thenThrow(new RuntimeException("Network error"));

        viewModel.sendAlert("emergency", "Network test message", "both", "high", "Dhaka");

        // Verify that the alert status is set to "failed"
        assertEquals("failed", viewModel.getAlertStatus().getValue());
    }

    /**
     * Tests sending alerts with different priorities (high and normal).
     * Verifies that the alert status is updated to "sent" for both high and normal priorities.
     */
    @Test
    public void sendAlertWithDifferentPriorities() {
        Alert highPriorityAlert = new Alert();
        highPriorityAlert.setStatus("sent");
        when(repository.sendAlert(highPriorityAlert)).thenReturn(highPriorityAlert);

        viewModel.sendAlert("general", "High priority test", "citizens", "high", "Dhaka");
        assertEquals("sent", viewModel.getAlertStatus().getValue());

        Alert normalPriorityAlert = new Alert();
        normalPriorityAlert.setStatus("sent");
        when(repository.sendAlert(normalPriorityAlert)).thenReturn(normalPriorityAlert);

        viewModel.sendAlert("general", "Normal priority test", "citizens", "normal", "Dhaka");
        assertEquals("sent", viewModel.getAlertStatus().getValue());
    }

    /**
     * Tests sending an alert with an empty message.
     * Verifies that the alert status is updated to "failed".
     */
    @Test
    public void sendAlertWithEmptyMessage() {
        Alert alert = new Alert();
        alert.setStatus("failed");
        when(repository.sendAlert(alert)).thenReturn(alert);

        viewModel.sendAlert("emergency", "", "citizens", "normal", "Dhaka");

        // Verify that the alert status is set to "failed"
        assertEquals("failed", viewModel.getAlertStatus().getValue());
    }

    /**
     * Tests sending multiple alerts sequentially.
     * Verifies that the alert status is correctly updated after each alert is sent.
     */
    @Test
    public void sendMultipleAlerts() {
        Alert firstAlert = new Alert();
        firstAlert.setStatus("sent");
        when(repository.sendAlert(firstAlert)).thenReturn(firstAlert);

        viewModel.sendAlert("general", "First alert", "citizens", "normal", "Dhaka");
        assertEquals("sent", viewModel.getAlertStatus().getValue());

        Alert secondAlert = new Alert();
        secondAlert.setStatus("failed");
        when(repository.sendAlert(secondAlert)).thenReturn(secondAlert);

        viewModel.sendAlert("emergency", "Second alert", "both", "high", "Chattogram");
        assertEquals("failed", viewModel.getAlertStatus().getValue());
    }
}
