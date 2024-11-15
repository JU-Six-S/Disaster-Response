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

public class VolunteerTaskViewModelTest2 {

    private VolunteerTaskViewModel viewModel;

    @Mock
    private TaskRepository mockTaskRepository;

    @Mock
    private FeedbackRepository mockFeedbackRepository;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        viewModel = new VolunteerTaskViewModel(mockTaskRepository, mockFeedbackRepository);
    }

    @Test
    public void testRegisterVolunteer() {
        // Mock the addVolunteer method to return true
        when(mockTaskRepository.addVolunteer(anyString(), anyString(), anyString(), anyString())).thenReturn(true);

        // Call the method and assert the result
        boolean isRegistered = viewModel.registerVolunteer("John Doe", "1234567890", "Medical", "Available");
        assertTrue(isRegistered);

        // Verify that the addVolunteer method was called with correct arguments
        verify(mockTaskRepository).addVolunteer("John Doe", "1234567890", "Medical", "Available");
    }

    @Test
    public void testRegisterVolunteer_withInvalidData() {
        // Mock the addVolunteer method to return false for invalid data
        when(mockTaskRepository.addVolunteer(anyString(), anyString(), anyString(), anyString())).thenReturn(false);

        // Attempt to register with invalid data (empty name)
        boolean isRegistered = viewModel.registerVolunteer("", "1234567890", "Medical", "Available");
        assertFalse(isRegistered);
    }

    @Test
    public void testRegisterVolunteer_shouldNotRegisterWithEmptyFields() {
        // Attempt to register with empty fields
        boolean isRegistered = viewModel.registerVolunteer("", "", "", "");
        assertFalse(isRegistered);
    }

    @Test
    public void testUpdateTaskStatus() {
        // Mock updateTaskStatus method to return true
        when(mockTaskRepository.updateTaskStatus(anyString(), anyString())).thenReturn(true);

        // Call the method and verify the status update
        boolean isUpdated = viewModel.updateTaskStatus("Task1", "Completed");
        assertTrue(isUpdated);

        // Verify that the updateTaskStatus method was called with correct arguments
        verify(mockTaskRepository).updateTaskStatus("Task1", "Completed");
    }

    @Test
    public void testAssignTask() {
        // Mock assignTask method to return true
        when(mockTaskRepository.assignTask(anyString())).thenReturn(true);

        // Assign task and verify the result
        boolean isAssigned = viewModel.assignTask("New Task Description");
        assertTrue(isAssigned);

        // Verify that the assignTask method was called
        verify(mockTaskRepository).assignTask("New Task Description");
    }

    @Test
    public void testAssignTask_withInvalidDescription() {
        // Mock the assignTask method to return false
        when(mockTaskRepository.assignTask(anyString())).thenReturn(false);

        // Try to assign an invalid task
        boolean isAssigned = viewModel.assignTask("");
        assertFalse(isAssigned);
    }

    // Add more test cases as needed
}
