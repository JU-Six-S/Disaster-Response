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

public class VolunteerTaskViewModelTest {

    private VolunteerTaskViewModel viewModel;

    @Mock
    private TaskRepository mockTaskRepository;

    @Mock
    private FeedbackRepository mockFeedbackRepository;

    @Before
    public void setup() {
        // Initialize the mock objects before each test
        MockitoAnnotations.openMocks(this); // Recommended over initMocks()
        viewModel = new VolunteerTaskViewModel(mockTaskRepository, mockFeedbackRepository);
    }

    @Test
    public void testRegisterVolunteer() {
        // Arrange: Mock the addVolunteer method
        when(mockTaskRepository.addVolunteer(anyString(), anyString(), anyString(), anyString())).thenReturn(true);

        // Act: Call the method under test
        boolean isRegistered = viewModel.registerVolunteer("John Doe", "1234567890", "Medical", "Available");

        // Assert: Verify the outcome
        assertTrue(isRegistered);
        verify(mockTaskRepository).addVolunteer("John Doe", "1234567890", "Medical", "Available");
    }

    @Test
    public void testRegisterVolunteer_withInvalidData() {
        // Arrange: Mock the addVolunteer method to return false for invalid data
        when(mockTaskRepository.addVolunteer(anyString(), anyString(), anyString(), anyString())).thenReturn(false);

        // Act: Call the method with invalid data (empty name)
        boolean isRegistered = viewModel.registerVolunteer("", "1234567890", "Medical", "Available");

        // Assert: Verify that registration fails due to invalid data
        assertFalse(isRegistered);
    }

    @Test
    public void testRegisterVolunteer_shouldNotRegisterWithEmptyFields() {
        // Act: Attempt registration with empty fields
        boolean isRegistered = viewModel.registerVolunteer("", "", "", "");

        // Assert: Ensure the registration fails when all fields are empty
        assertFalse(isRegistered);
    }

    // Additional test cases for other ViewModel methods...
}
