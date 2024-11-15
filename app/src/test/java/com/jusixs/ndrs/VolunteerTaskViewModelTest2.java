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
public class VolunteerTaskViewModelTest2 {

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
        MockitoAnnotations.openMocks(this); // Initialize mock objects
        viewModel = new VolunteerTaskViewModel(mockTaskRepository, mockFeedbackRepository);
    }

    /**
     * Tests the successful registration of a volunteer with valid data.
     */
    @Test
    public void testRegisterVolunteerWithValidData() {
        // Arrange: Mock the addVolunteer method to return true for valid input
        when(mockTaskRepository.addVolunteer(anyString(), anyString(), anyString(), anyString())).thenReturn(true);

        // Act: Register the volunteer
        boolean isRegistered = viewModel.registerVolunteer("John Doe", "1234567890", "Medical", "Available");

        // Assert: Verify that registration was successful
        assertTrue(isRegistered);
        verify(mockTaskRepository).addVolunteer("John Doe", "1234567890", "Medical", "Available");
    }

    /**
     * Tests registration of a volunteer with invalid data (e.g., empty name).
     */
    @Test
    public void testRegisterVolunteerWithInvalidData() {
        // Arrange: Mock the addVolunteer method to return false for invalid data
        when(mockTaskRepository.addVolunteer(anyString(), anyString(), anyString(), anyString())).thenReturn(false);

        // Act: Attempt to register a volunteer with an empty name
        boolean isRegistered = viewModel.registerVolunteer("", "1234567890", "Medical", "Available");

        // Assert: Ensure registration fails
        assertFalse(isRegistered);
    }

    /**
     * Tests registration of a volunteer with all empty fields.
     */
    @Test
    public void testRegisterVolunteerWithEmptyFields() {
        // Act: Attempt registration with empty fields
        boolean isRegistered = viewModel.registerVolunteer("", "", "", "");

        // Assert: Ensure registration fails with empty fields
        assertFalse(isRegistered);
    }

    /**
     * Tests updating the task status with valid input.
     */
    @Test
    public void testUpdateTaskStatusWithValidData() {
        // Arrange: Mock updateTaskStatus method to return true
        when(mockTaskRepository.updateTaskStatus(anyString(), anyString())).thenReturn(true);

        // Act: Update task status
        boolean isUpdated = viewModel.updateTaskStatus("Task1", "Completed");

        // Assert: Verify that status update was successful
        assertTrue(isUpdated);
        verify(mockTaskRepository).updateTaskStatus("Task1", "Completed");
    }

    /**
     * Tests assigning a task with a valid description.
     */
    @Test
    public void testAssignTaskWithValidDescription() {
        // Arrange: Mock assignTask method to return true
        when(mockTaskRepository.assignTask(anyString())).thenReturn(true);

        // Act: Assign a task
        boolean isAssigned = viewModel.assignTask("New Task Description");

        // Assert: Verify the task was assigned successfully
        assertTrue(isAssigned);
        verify(mockTaskRepository).assignTask("New Task Description");
    }

    /**
     * Tests assigning a task with an invalid (empty) description.
     */
    @Test
    public void testAssignTaskWithInvalidDescription() {
        // Arrange: Mock assignTask method to return false for invalid input
        when(mockTaskRepository.assignTask(anyString())).thenReturn(false);

        // Act: Attempt to assign a task with an empty description
        boolean isAssigned = viewModel.assignTask("");

        // Assert: Ensure task assignment fails
        assertFalse(isAssigned);
    }
}
