package com.jusixs.ndrs;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.jusixs.ndrs.data.repository.FeedbackRepository;
import com.jusixs.ndrs.data.repository.TaskRepository;
import com.jusixs.ndrs.ui.viewmodel.VolunteerTaskViewModel;

/**
 * Unit tests for the VolunteerTaskViewModel class.
 */
public class VolunteerTaskViewModelTest {

    private VolunteerTaskViewModel viewModel;

    @Mock
    private TaskRepository mockTaskRepository;

    @Mock
    private FeedbackRepository mockFeedbackRepository;

    /**
     * Sets up the test environment by initializing mock objects and the ViewModel.
     */
    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        viewModel = new VolunteerTaskViewModel(mockTaskRepository, mockFeedbackRepository);
    }

    /**
     * Tests the successful registration of a volunteer with valid data.
     */
    @Test
    public void testRegisterVolunteerWithValidData() {
        // Arrange: Mock the addVolunteer method to return true for valid input
        when(mockTaskRepository.addVolunteer(anyString(), anyString(), anyString(), anyString())).thenReturn(true);

        // Act: Register the volunteer with valid input
        boolean isRegistered = viewModel.registerVolunteer("John Doe", "1234567890", "Medical", "Available");

        // Assert: Verify registration was successful and the method was called with correct arguments
        assertTrue(isRegistered);
        verify(mockTaskRepository).addVolunteer("John Doe", "1234567890", "Medical", "Available");
    }

    /**
     * Tests the registration of a volunteer with invalid data (e.g., empty name).
     */
    @Test
    public void testRegisterVolunteerWithInvalidData() {
        // Arrange: Mock the addVolunteer method to return false for invalid data
        when(mockTaskRepository.addVolunteer(anyString(), anyString(), anyString(), anyString())).thenReturn(false);

        // Act: Attempt to register a volunteer with an empty name
        boolean isRegistered = viewModel.registerVolunteer("", "1234567890", "Medical", "Available");

        // Assert: Verify that registration fails due to invalid input
        assertFalse(isRegistered);
        verify(mockTaskRepository).addVolunteer("", "1234567890", "Medical", "Available");
    }

    /**
     * Tests the registration of a volunteer when all fields are empty.
     */
    @Test
    public void testRegisterVolunteerWithEmptyFields() {
        // Act: Attempt registration with all fields empty
        boolean isRegistered = viewModel.registerVolunteer("", "", "", "");

        // Assert: Ensure registration fails with empty fields
        assertFalse(isRegistered);
        // No need to verify the mock method call since input validation fails at the ViewModel level
    }

    // Additional test cases can be added here for other ViewModel methods...
}
