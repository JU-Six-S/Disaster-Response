package com.jusixs.ndrs;

import com.jusixs.ndrs.data.model.Task;
import com.jusixs.ndrs.data.repository.FeedbackRepository;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the FeedbackRepository class.
 */
public class FeedbackRepositoryTest2 {

    private FeedbackRepository feedbackRepository;

    /**
     * Sets up the FeedbackRepository instance before each test case.
     */
    @Before
    public void setup() {
        feedbackRepository = new FeedbackRepository();
    }

    /**
     * Tests adding valid feedback to an existing task.
     */
    @Test
    public void testAddFeedbackValid() {
        // Arrange: Create a task and add it to the repository
        Task task = new Task("Task1", "Task Description", "John Doe", "Pending");
        feedbackRepository.addTask(task);

        // Act: Add valid feedback
        boolean isFeedbackAdded = feedbackRepository.addFeedback("Great Task", "John Doe", "Task1");

        // Assert: Check if the feedback was successfully added
        assertTrue(isFeedbackAdded);
    }

    /**
     * Tests adding feedback to a non-existing task.
     */
    @Test
    public void testAddFeedbackInvalidTask() {
        // Act: Try to add feedback to a non-existing task
        boolean isFeedbackAdded = feedbackRepository.addFeedback("Great Task", "John Doe", "NonExistingTask");

        // Assert: Feedback should not be added
        assertFalse(isFeedbackAdded);
    }

    /**
     * Tests adding empty feedback to an existing task.
     */
    @Test
    public void testAddFeedbackEmptyFeedback() {
        // Arrange: Create a task and add it to the repository
        Task task = new Task("Task1", "Task Description", "John Doe", "Pending");
        feedbackRepository.addTask(task);

        // Act: Try to add empty feedback
        boolean isFeedbackAdded = feedbackRepository.addFeedback("", "John Doe", "Task1");

        // Assert: Feedback should not be added
        assertFalse(isFeedbackAdded);
    }

    /**
     * Tests adding null feedback to an existing task.
     */
    @Test
    public void testAddFeedbackNullFeedback() {
        // Arrange: Create a task and add it to the repository
        Task task = new Task("Task1", "Task Description", "John Doe", "Pending");
        feedbackRepository.addTask(task);

        // Act: Try to add null feedback
        boolean isFeedbackAdded = feedbackRepository.addFeedback(null, "John Doe", "Task1");

        // Assert: Feedback should not be added
        assertFalse(isFeedbackAdded);
    }

    /**
     * Tests adding feedback with a non-existent task name.
     */
    @Test
    public void testAddFeedbackNonExistentTask() {
        // Act: Try to add feedback to a non-existent task
        boolean isFeedbackAdded = feedbackRepository.addFeedback("Great Task", "John Doe", "NonExistingTask");

        // Assert: Feedback should not be added
        assertFalse(isFeedbackAdded);
    }
}
