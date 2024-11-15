package com.jusixs.ndrs;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jusixs.ndrs.data.repository.FeedbackRepository;

/**
 * Unit tests for the FeedbackRepository class.
 */
public class FeedbackRepositoryTest {

    private FeedbackRepository feedbackRepository;

    /**
     * Sets up the FeedbackRepository instance before each test.
     */
    @Before
    public void setup() {
        feedbackRepository = new FeedbackRepository();
    }

    /**
     * Tests the addFeedback method with valid and invalid feedback data.
     */
    @Test
    public void testAddFeedback() {
        // Valid feedback data
        boolean isFeedbackAdded = feedbackRepository.addFeedback("Excellent work!", "John Doe", "Task1");
        assertTrue(isFeedbackAdded);

        // Invalid feedback data (empty feedback string)
        boolean isInvalidFeedbackAdded = feedbackRepository.addFeedback("", "John Doe", "Task1");
        assertFalse(isInvalidFeedbackAdded);
    }

    /**
     * Tests the addFeedback method with a non-existent task name.
     */
    @Test
    public void testAddFeedbackWithInvalidTask() {
        // Invalid feedback due to a non-existent task
        boolean isInvalidTaskFeedbackAdded = feedbackRepository.addFeedback("Great Task", "John Doe", "NonExistingTask");
        assertFalse(isInvalidTaskFeedbackAdded);
    }
}
