package com.jusixs.ndrs.data.repository;

public class FeedbackRepository {
    public boolean submitFeedback(String feedback) {
        return feedback != null && !feedback.trim().isEmpty();
    }
}
