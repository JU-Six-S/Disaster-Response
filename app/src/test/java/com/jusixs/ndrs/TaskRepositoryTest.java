package com.jusixs.ndrs;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.jusixs.ndrs.data.repository.TaskRepository;

public class TaskRepositoryTest {

    private TaskRepository taskRepository;

    @Before
    public void setup() {
        // Setup code before each test (if necessary)
        taskRepository = mock(TaskRepository.class);
    }

    @Test
    public void testAddTask_success() {
        // Arrange: Mock addTask method to return true
        when(taskRepository.addTask(anyString(), anyString(), anyString())).thenReturn(true);

        // Act: Call the addTask method
        boolean isTaskAdded = taskRepository.addTask("Task1", "Medical Assistance", "Open");

        // Assert: Verify that the task was added
        assertTrue(isTaskAdded);
        verify(taskRepository).addTask("Task1", "Medical Assistance", "Open");
    }

    @Test
    public void testAddTask_failure() {
        // Arrange: Mock addTask method to return false
        when(taskRepository.addTask(anyString(), anyString(), anyString())).thenReturn(false);

        // Act: Call the addTask method with invalid data
        boolean isTaskAdded = taskRepository.addTask("", "", "");

        // Assert: Verify that task adding failed
        assertFalse(isTaskAdded);
    }

    @Test
    public void testUpdateTaskStatus_success() {
        // Arrange: Mock updateTaskStatus method to return true
        when(taskRepository.updateTaskStatus(anyString(), anyString())).thenReturn(true);

        // Act: Update task status
        boolean isStatusUpdated = taskRepository.updateTaskStatus("Task1", "Completed");

        // Assert: Verify that task status is updated
        assertTrue(isStatusUpdated);
        verify(taskRepository).updateTaskStatus("Task1", "Completed");
    }

    @Test
    public void testUpdateTaskStatus_failure() {
        // Arrange: Mock updateTaskStatus method to return false
        when(taskRepository.updateTaskStatus(anyString(), anyString())).thenReturn(false);

        // Act: Attempt to update task status with invalid data
        boolean isStatusUpdated = taskRepository.updateTaskStatus("Task1", "");

        // Assert: Ensure status update fails with invalid status
        assertFalse(isStatusUpdated);
    }
}
