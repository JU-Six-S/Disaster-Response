package com.jusixs.ndrs;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jusixs.ndrs.data.repository.FeedbackRepository;

public class FeedbackRepositoryTest {

    private FeedbackRepository feedbackRepository;

    @Before
    public void setup() {
        feedbackRepository = new FeedbackRepository();
    }

    @Test
    public void testAddFeedback() {
        // Valid feedback data
        boolean result = feedbackRepository.addFeedback("Excellent work!", "John Doe", "Task1");
        assertTrue(result);

        // Invalid feedback data (empty feedback)
        boolean invalidResult = feedbackRepository.addFeedback("", "John Doe", "Task1");
        assertFalse(invalidResult);
    }

    @Test
    public void testAddFeedback_withInvalidTask() {
        // Invalid feedback due to non-existent task
        boolean invalidResult = feedbackRepository.addFeedback("Great Task", "John Doe", "NonExistingTask");
        assertFalse(invalidResult);
    }
}
