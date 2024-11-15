package com.jusixs.ndrs.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a task with details and feedback.
 * Allows adding feedback for the task.
 */
public class Task {

    private String name;
    private String description;
    private String assignedTo;
    private String status;
    private List<String> feedbackList;

    /**
     * Constructor to initialize a Task object.
     *
     * @param name        The name of the task.
     * @param description The description of the task.
     * @param assignedTo  The name of the person assigned to the task.
     * @param status      The current status of the task.
     */
    public Task(String name, String description, String assignedTo, String status) {
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.status = status;
        this.feedbackList = new ArrayList<>(); // Initialize the feedback list
    }

    // Getters and Setters

    /**
     * Gets the name of the task.
     *
     * @return The name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the task.
     *
     * @param name The name of the task.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the task.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the task.
     *
     * @param description The description of the task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the name of the person assigned to the task.
     *
     * @return The name of the person assigned to the task.
     */
    public String getAssignedTo() {
        return assignedTo;
    }

    /**
     * Sets the name of the person assigned to the task.
     *
     * @param assignedTo The name of the person assigned to the task.
     */
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * Gets the current status of the task.
     *
     * @return The status of the task.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the task.
     *
     * @param status The status of the task.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Adds feedback from a volunteer to the task.
     *
     * @param volunteerName The name of the volunteer providing feedback.
     * @param feedback      The feedback provided by the volunteer.
     */
    public void addFeedback(String volunteerName, String feedback) {
        if (isValidInput(volunteerName, feedback)) {
            String feedbackEntry = "Feedback from " + volunteerName + ": " + feedback;
            feedbackList.add(feedbackEntry); // Add the feedback to the list
        } else {
            System.out.println("Invalid feedback or volunteer name"); // Log invalid input
        }
    }

    /**
     * Validates the volunteer name and feedback.
     *
     * @param volunteerName The name of the volunteer.
     * @param feedback      The feedback provided by the volunteer.
     * @return true if the input is valid, false otherwise.
     */
    private boolean isValidInput(String volunteerName, String feedback) {
        return volunteerName != null && !volunteerName.isEmpty() && feedback != null && !feedback.isEmpty();
    }

    /**
     * Gets the list of feedback provided for the task.
     *
     * @return The list of feedback.
     */
    public List<String> getFeedbackList() {
        return feedbackList;
    }
}
