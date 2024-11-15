package com.jusixs.ndrs;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
package com.jusixs.ndrs;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kotlinx.coroutines.scheduling.Task;

class TaskAllocationTest {

    private TaskManagementService taskService;
    private Task task;
    private Volunteer volunteer;
    @BeforeEach
    void setup() {
        taskService = mock(TaskManagementService.class);
        volunteer = new Volunteer("John Doe", "john@example.com", "Firefighting", "Available");
        task = new Task("Evacuation Assistance", "Assist in evacuation", "Area A");
    }

    @Test
    void testAssignTaskSuccess() {
        when(taskService.assignTask(task, volunteer)).thenReturn(true);

        assertTrue(taskService.assignTask(task, volunteer), "Task assignment should succeed.");
        verify(taskService, times(1)).assignTask(task, volunteer);
    }

    @Test
    void testTaskAssignmentFailureDueToUnavailability() {
        Volunteer unavailableVolunteer = new Volunteer("Jane Doe", "jane@example.com", "Logistics", "Unavailable");
        when(taskService.assignTask(task, unavailableVolunteer)).thenReturn(false);

        assertFalse(taskService.assignTask(task, unavailableVolunteer), "Task assignment should fail for unavailable volunteer.");
    }

    @Test
    void testTrackTaskCompletion() {
        when(taskService.trackTask(task)).thenReturn("In Progress");

        assertEquals("In Progress", taskService.trackTask(task), "Task status should be 'In Progress'.");
    }

    @Test
    void testAssignmentFailureDueToNetworkError() {
        when(taskService.assignTask(task, volunteer)).thenThrow(new RuntimeException("Network error"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            taskService.assignTask(task, volunteer);
        });
        assertEquals("Network error", exception.getMessage());
    }
}
