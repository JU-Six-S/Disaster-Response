package com.jusixs.ndrs;

import com.jusixs.ndrs.data.repository.TaskRepository;
import com.jusixs.ndrs.data.repository.FeedbackRepository;
import com.jusixs.ndrs.ui.viewmodel.VolunteerTaskViewModel;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Unit tests for the VolunteerTaskViewModel class.
 */
public class VolunteerTaskViewModelTest3 {

    private VolunteerTaskViewModel viewModel;
    private TaskRepository mockTaskRepository;
    private FeedbackRepository mockFeedbackRepository;

    /**
     * Sets up the test environment by initializing mock repositories and the ViewModel.
     */
    @Before
    public void setup() {
        // Initialize mock repositories
        mockTaskRepository = mock(TaskRepository.class);
        mockFeedbackRepository = mock(FeedbackRepository.class);

        // Initialize the ViewModel with mock dependencies
        viewModel = new VolunteerTaskViewModel(mockTaskRepository, mockFeedbackRepository);
    }

    /**
     * Tests the successful submission of feedback.
     */
    @Test
    public void testSubmitFeedbackWithValidData() {
        // Arrange: Mock the addFeedback method to return true
        when(mockFeedbackRepository.addFeedback(anyString(), anyString(), anyString())).thenReturn(true);

        // Act: Submit valid feedback
        boolean result = viewModel.submitFeedback("Great work!", "John Doe", "Task1");

        // Assert: Verify that feedback submission was successful
        assertTrue(result);
        verify(mockFeedbackRepository).addFeedback("Great work!", "John Doe", "Task1");
    }

    /**
     * Tests the submission of invalid feedback (empty feedback).
     */
    @Test
    public void testSubmitFeedbackWithInvalidData() {
        // Arrange: Mock the addFeedback method to return false for invalid feedback
        when(mockFeedbackRepository.addFeedback(anyString(), anyString(), anyString())).thenReturn(false);

        // Act: Submit empty feedback
        boolean result = viewModel.submitFeedback("", "John Doe", "Task1");

        // Assert: Verify that feedback submission failed
        assertFalse(result);
    }

    /**
     * Tests feedback submission for a task that doesn't exist.
     */
    @Test
    public void testSubmitFeedbackForNonExistingTask() {
        // Arrange: Mock the addFeedback method to return false if task doesn't exist
        when(mockFeedbackRepository.addFeedback(anyString(), anyString(), anyString())).thenReturn(false);

        // Act: Submit feedback for a non-existing task
        boolean result = viewModel.submitFeedback("Great work!", "John Doe", "NonExistingTask");

        // Assert: Verify that feedback submission failed due to non-existing task
        assertFalse(result);
    }

    /**
     * Tests the successful registration of a volunteer with valid data.
     */
    @Test
    public void testRegisterVolunteerWithValidData() {
        // Act: Register volunteer with valid data
        boolean result = viewModel.registerVolunteer("John Doe", "1234567890", "Medical", "Available");

        // Assert: Verify that volunteer registration was successful
        assertTrue(result);
    }

    /**
     * Tests the registration of a volunteer with invalid data (empty name).
     */
    @Test
    public void testRegisterVolunteerWithInvalidData() {
        // Act: Attempt to register a volunteer with an empty name
        boolean result = viewModel.registerVolunteer("", "1234567890", "Medical", "Available");

        // Assert: Ensure registration fails due to invalid data
        assertFalse(result);
    }

    /**
     * Tests the successful assignment of a task with a valid description.
     */
    @Test
    public void testAssignTaskWithValidDescription() {
        // Arrange: Mock the assignTask method to return true
        when(mockTaskRepository.assignTask(anyString())).thenReturn(true);

        // Act: Assign a task with a valid description
        boolean result = viewModel.assignTask("New Task Description");

        // Assert: Verify task assignment was successful
        assertTrue(result);
        verify(mockTaskRepository).assignTask("New Task Description");
    }

    /**
     * Tests task assignment with an invalid (empty) task description.
     */
    @Test
    public void testAssignTaskWithInvalidDescription() {
        // Arrange: Mock the assignTask method to return false for invalid description
        when(mockTaskRepository.assignTask(anyString())).thenReturn(false);

        // Act: Attempt to assign an empty task description
        boolean result = viewModel.assignTask("");

        // Assert: Ensure task assignment fails due to invalid description
        assertFalse(result);
    }

    /**
     * Tests the allocation of a task with a valid description.
     */
    @Test
    public void testAllocateTaskWithValidDescription() {
        // Act: Allocate task with a valid description
        boolean result = viewModel.allocateTask("New Task");

        // Assert: Verify task allocation was successful
        assertTrue(result);
    }

    /**
     * Tests the allocation of a task with an empty description.
     */
    @Test
    public void testAllocateTaskWithInvalidDescription() {
        // Act: Attempt to allocate task with an empty description
        boolean result = viewModel.allocateTask("");

        // Assert: Ensure task allocation fails due to empty description
        assertFalse(result);
    }
}
