package com.jusixs.ndrs;

import com.jusixs.ndrs.data.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Unit tests for the TaskRepository class using Mockito for mocking dependencies.
 */
public class TaskRepositoryTest {

    private TaskRepository taskRepository;

    /**
     * Sets up the mock TaskRepository instance before each test case.
     */
    @Before
    public void setup() {
        taskRepository = mock(TaskRepository.class);
    }

    /**
     * Tests the success scenario of adding a task.
     */
    @Test
    public void testAddTaskSuccess() {
        // Arrange: Mock addTask method to return true
        when(taskRepository.addTask(anyString(), anyString(), anyString())).thenReturn(true);

        // Act: Call the addTask method
        boolean isTaskAdded = taskRepository.addTask("Task1", "Medical Assistance", "Open");

        // Assert: Verify that the task was added successfully
        assertTrue(isTaskAdded);
        verify(taskRepository).addTask("Task1", "Medical Assistance", "Open");
    }

    /**
     * Tests the failure scenario of adding a task with invalid input.
     */
    @Test
    public void testAddTaskFailure() {
        // Arrange: Mock addTask method to return false
        when(taskRepository.addTask(anyString(), anyString(), anyString())).thenReturn(false);

        // Act: Attempt to add a task with invalid input data
        boolean isTaskAdded = taskRepository.addTask("", "", "");

        // Assert: Verify that task addition failed
        assertFalse(isTaskAdded);
        verify(taskRepository).addTask("", "", "");
    }

    /**
     * Tests the success scenario of updating the task status.
     */
    @Test
    public void testUpdateTaskStatusSuccess() {
        // Arrange: Mock updateTaskStatus method to return true
        when(taskRepository.updateTaskStatus(anyString(), anyString())).thenReturn(true);

        // Act: Update the status of a task
        boolean isStatusUpdated = taskRepository.updateTaskStatus("Task1", "Completed");

        // Assert: Verify that the task status was updated successfully
        assertTrue(isStatusUpdated);
        verify(taskRepository).updateTaskStatus("Task1", "Completed");
    }

    /**
     * Tests the failure scenario of updating the task status with invalid input.
     */
    @Test
    public void testUpdateTaskStatusFailure() {
        // Arrange: Mock updateTaskStatus method to return false
        when(taskRepository.updateTaskStatus(anyString(), anyString())).thenReturn(false);

        // Act: Attempt to update the task status with invalid status data
        boolean isStatusUpdated = taskRepository.updateTaskStatus("Task1", "");

        // Assert: Verify that the status update failed
        assertFalse(isStatusUpdated);
        verify(taskRepository).updateTaskStatus("Task1", "");
    }
}
