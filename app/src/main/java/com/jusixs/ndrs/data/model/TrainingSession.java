package com.jusixs.ndrs.data.model;

/**
 * Model class representing a training session.
 */
public class TrainingSession {
    private final String sessionId;
    private final String title;
    private final String type;
    private final String schedule;
    private final String trainer;
    private final boolean isRegistered;

    /**
     * Constructs a TrainingSession object with given details.
     *
     * @param sessionId   Unique identifier for the session.
     * @param title       Title of the training session.
     * @param type        Type of training (theoretical or practical).
     * @param schedule    Schedule of the session.
     * @param trainer     Trainer of the session.
     * @param isRegistered Whether the user is registered.
     */
    public TrainingSession(String sessionId, String title, String type, String schedule, String trainer, boolean isRegistered) {
        this.sessionId = sessionId;
        this.title = title;
        this.type = type;
        this.schedule = schedule;
        this.trainer = trainer;
        this.isRegistered = isRegistered;
    }

    // Getters here

    public String getSessionId() { return sessionId; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getSchedule() { return schedule; }
    public String getTrainer() { return trainer; }
    public boolean isRegistered() { return isRegistered; }
}
