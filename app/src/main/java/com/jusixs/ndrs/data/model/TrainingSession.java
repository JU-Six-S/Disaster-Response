package com.jusixs.ndrs.data.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing a training session with details such as type, schedule, and trainer.
 * Implements Serializable to allow easy passing between activities and fragments.
 */
public class TrainingSession implements Serializable {

    private final String sessionId;
    private final String title;
    private final String type;
    private final String schedule;
    private final String trainer;
    private final String region;
    private final String role;
    private boolean isRegistered;
    private boolean attendanceMarked;
    private List<String> feedbackList;

    /**
     * Constructs a TrainingSession with the specified details.
     *
     * @param sessionId       Unique identifier for the session.
     * @param title           Title of the training session.
     * @param type            Type of training (e.g., theoretical or practical).
     * @param schedule        Schedule of the session.
     * @param trainer         Name of the trainer.
     * @param region          Region where the training is available.
     * @param role            Role of the user for this session.
     * @param isRegistered    Indicates whether the user is registered.
     */
    public TrainingSession(String sessionId, String title, String type, String schedule,
                           String trainer, String region, String role, boolean isRegistered) {
        this.sessionId = sessionId;
        this.title = title;
        this.type = type;
        this.schedule = schedule;
        this.trainer = trainer;
        this.region = region;
        this.role = role;
        this.isRegistered = isRegistered;
        this.attendanceMarked = false;
        this.feedbackList = new ArrayList<>();
    }

    /**
     * Gets the session ID.
     *
     * @return session ID as a String.
     */
    public String getSessionId() { return sessionId; }

    /**
     * Gets the title of the training session.
     *
     * @return title of the session.
     */
    public String getTitle() { return title; }

    /**
     * Gets the type of the training session.
     *
     * @return type of training.
     */
    public String getType() { return type; }

    /**
     * Gets the schedule of the session.
     *
     * @return schedule as a String.
     */
    public String getSchedule() { return schedule; }

    /**
     * Gets the trainer's name.
     *
     * @return name of the trainer.
     */
    public String getTrainer() { return trainer; }

    /**
     * Gets the region where the training is available.
     *
     * @return region as a String.
     */
    public String getRegion() { return region; }

    /**
     * Gets the role of the user for this session.
     *
     * @return role of the user.
     */
    public String getRole() { return role; }

    /**
     * Checks if the user is registered for the session.
     *
     * @return true if registered, false otherwise.
     */
    public boolean isRegistered() { return isRegistered; }

    /**
     * Checks if the attendance has been marked.
     *
     * @return true if attendance is marked, false otherwise.
     */
    public boolean isAttendanceMarked() { return attendanceMarked; }

    /**
     * Sets the registration status of the user.
     *
     * @param registered true to register, false to unregister.
     */
    public void setRegistered(boolean registered) { isRegistered = registered; }

    /**
     * Sets the attendance status.
     *
     * @param attendanceMarked true to mark attendance, false to unmark.
     */
    public void setAttendanceMarked(boolean attendanceMarked) { this.attendanceMarked = attendanceMarked; }

    /**
     * Adds feedback to the feedback list for this session.
     *
     * @param feedback Feedback text to be added.
     */
    public void addFeedback(String feedback) {
        feedbackList.add(feedback);
    }

    /**
     * Retrieves the list of feedback entries.
     *
     * @return List of feedback as strings.
     */
    public List<String> getFeedbackList() {
        return feedbackList;
    }

    /**
     * Compares this TrainingSession to another object for equality based on sessionId.
     *
     * @param o Object to compare.
     * @return true if both have the same sessionId, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingSession that = (TrainingSession) o;
        return sessionId.equals(that.sessionId);
    }

    /**
     * Generates a hash code for this TrainingSession based on sessionId.
     *
     * @return Hash code as an integer.
     */
    @Override
    public int hashCode() {
        return Objects.hash(sessionId);
    }

    /**
     * Returns a string representation of the TrainingSession with key details.
     *
     * @return String representation of the session.
     */
    @Override
    public String toString() {
        return "TrainingSession{" +
                "sessionId='" + sessionId + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", schedule='" + schedule + '\'' +
                ", trainer='" + trainer + '\'' +
                ", region='" + region + '\'' +
                ", role='" + role + '\'' +
                ", isRegistered=" + isRegistered +
                ", attendanceMarked=" + attendanceMarked +
                ", feedbackList=" + feedbackList +
                '}';
    }
}
