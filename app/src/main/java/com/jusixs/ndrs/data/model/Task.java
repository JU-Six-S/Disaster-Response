package com.jusixs.ndrs.data.model;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private String description;
    private String assignedTo;
    private String status;
    private List<String> feedbackList; // Declare the feedback list as an instance variable

    // Constructor
    public Task(String name, String description, String assignedTo, String status) {
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.status = status;
        this.feedbackList = new ArrayList<>(); // Initialize the feedback list
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method to add feedback to the task
    public void addFeedback(String volunteerName, String feedback) {
        if (volunteerName != null && !volunteerName.isEmpty() && feedback != null && !feedback.isEmpty()) {
            String feedbackEntry = "Feedback from " + volunteerName + ": " + feedback;
            feedbackList.add(feedbackEntry); // Add the feedback to the list
        } else {
            System.out.println("Invalid feedback or volunteer name"); // Log invalid input
        }
    }

    // Getter for feedback list
    public List<String> getFeedbackList() {
        return feedbackList;
    }
}
